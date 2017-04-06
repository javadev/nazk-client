package com.github.javadev.nazk.client;

import com.github.underscore.lodash.$;
import com.github.underscore.Function;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class HttpClient implements NazkClient {
    private static final String BASE_URL = "https://public-api.nazk.gov.ua/v1/declaration";
    private static final String BASE_URL_HTML = "https://public.nazk.gov.ua/declaration/";

    private final String baseUrl;

    private HttpClient(final String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public static HttpClient createDefault() {
        return new HttpClient(BASE_URL);
    }

    private $.FetchResponse get(final String resourceUrl) {
        return $.fetch(this.baseUrl + resourceUrl, 120000, 120000);
    }

    @Override
    public Map<String, Object> getDeclarations(String queryString) {
        return (Map<String, Object>) get("/?q=" + queryString).json();
    }

    private static class CallableImpl implements Callable<Map<String, Object>> {

        private final NazkClient nazkClient;
        private final String id;
        private final String linkPdf;

        public CallableImpl(NazkClient nazkClient, String id, String linkPdf) {
            this.nazkClient = nazkClient;
            this.id = id;
            this.linkPdf = linkPdf;
        }

        public Map<String, Object> call() {
            final Map<String, Object> declaration = nazkClient.getDeclaration(id);
            final String declarationHtml = nazkClient.getDeclarationHtml(id);
            return new HashMap<String, Object>() { {
                put("id", id);
                put("json", $.toJson(declaration));
                put("html", declarationHtml);
                put("pdf", linkPdf == null ? null : $.fetch(linkPdf).blob());
            } };
        }
    }

    @Override
    public List<Map<String, Object>> getDeclarationsBatch(String queryString, int page) {
        Map<String, Object> data = (Map<String, Object>) get("/?q=" + queryString + "&page=" + page).json();
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        if ($.get(data, "error") != null) {
            return result;
        }
        final ExecutorService executor = Executors.newFixedThreadPool(100);
        final List<Callable<Map<String, Object>>> callables = new ArrayList<Callable<Map<String, Object>>>();
        for (int index = 0; index < Math.min((Long) $.get(data, "page.batchSize"),
            Long.parseLong((String) $.get(data, "page.totalItems"))); index += 1) {
            String id = (String) $.get(data, "items." + index + ".id");
            String linkPdf = (String) $.get(data, "items." + index + ".linkPDF");
            callables.add(new CallableImpl(this, id, linkPdf));
        }
        try {
            for (Future<Map<String, Object>> future : executor.invokeAll(callables)) {
                try {
                    result.add(future.get());
                } catch (ExecutionException ex) {
                    System.out.println("ExecutionException - " + ex.getMessage());
                }
            }
        } catch (InterruptedException ex) {
            System.out.println("InterruptedException - " + ex.getMessage());
        }
        executor.shutdown();
        return result;
    }

    private static class CallableSaveImpl implements Callable<Void> {

        private final String directoryName;
        private final Map<String, Object> declaration;

        public CallableSaveImpl(String directoryName, Map<String, Object> declaration) {
            this.directoryName = directoryName;
            this.declaration = declaration;
        }

        public Void call() {
            if (declaration.get("pdf") != null) {
                try {
                    FileOutputStream stream = new FileOutputStream(directoryName + "/"
                        + (String) declaration.get("id") + ".pdf");
                    stream.write((byte[]) declaration.get("pdf"));
                    stream.close();
                } catch (IOException ex) {
                }
            }
            try {
                OutputStreamWriter writerHtml = new OutputStreamWriter(
                    new FileOutputStream(directoryName + "/"
                    + (String) declaration.get("id") + ".html"), "UTF-8");
                writerHtml.write((String) declaration.get("html"));
                writerHtml.close();
            } catch (IOException ex) {
            }
            try {
                OutputStreamWriter writerJson = new OutputStreamWriter(
                    new FileOutputStream(directoryName + "/"
                    + (String) declaration.get("id") + ".json"), "UTF-8");
                writerJson.write((String) declaration.get("json"));
                writerJson.close();
            } catch (IOException ex) {
            }
            return null;
        }
    }

    @Override
    public int getAndSaveAllDeclarations(String queryString, String directoryName, int maxPages) {
        int index = 0;
        int resultCount = 0;
        new File(directoryName).mkdirs();        
        List<Map<String, Object>> declarations = getDeclarationsBatch(queryString, index);
        resultCount = declarations.size();
        final ExecutorService executor = Executors.newFixedThreadPool(100);
        while(declarations.size() > 0 && (maxPages == 0 || index < maxPages)) {
            final List<Callable<Void>> callables = new ArrayList<Callable<Void>>();
            for (Map<String, Object> declaration : declarations) {
                callables.add(new CallableSaveImpl(directoryName, declaration));
            }
            try {
                executor.invokeAll(callables);
            } catch (InterruptedException ex) {
            }
            index += 1;
            if (maxPages > 1) {
                declarations = getDeclarationsBatch(queryString, index);
                resultCount += declarations.size();
            }
        } 
        executor.shutdown();
        return resultCount;
    }

    @Override
    public Map<String, Object> getDeclaration(String id) {
        return (Map<String, Object>) get("/" + id).json();
    }

    @Override
    public String getDeclarationHtml(String id) {
        return $.fetch(BASE_URL_HTML + id).text();
    }

    public static void main(String ... args) {
        String query = "";
        String dest = ".";
        if (args.length == 0) {
            final String message = "Java client for declarations from the nazk.gov.ua.\n\n"
                + "For docs, license, tests, and downloads, see: https://github.com/javadev/nazk-client\n\n"
                + "Usage: java -jar nazk-client.jar "
                + "--query=3371ace7-177b-44d6-ba2a-53e023f740be --dest=test\n";
            System.out.println(message);
        } else {
            for (String arg : args) {
                if (arg.startsWith("--query=")) {
                    query = arg.substring("--query=".length()).trim().replace("\"", "");
                } else if (arg.startsWith("--dest=")) {
                    dest = arg.substring("--dest=".length()).trim();
                }
            }
            int resultCount = HttpClient.createDefault().getAndSaveAllDeclarations(query, dest, 1);
            System.out.println(resultCount + " declaration(s) was(were) downloaded to the folder " + dest);
        }
    }
}
