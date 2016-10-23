package com.github.javadev.nazk.client;

import com.github.underscore.lodash.$;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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
        return $.fetch(this.baseUrl + resourceUrl);
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
                put("json", $.toJson(declaration));
                put("html", declarationHtml);
                put("pdf", linkPdf == null ? null : $.fetch(linkPdf).blob());
            } };
        }
    }

    @Override
    public List<Map<String, Object>> getDeclarationsBatch(int page) {
        Map<String, Object> data = (Map<String, Object>) get("/?page=" + page).json();
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        final ExecutorService executor = Executors.newFixedThreadPool(100);
        final List<Callable<Map<String, Object>>> callables = new ArrayList<Callable<Map<String, Object>>>();
        for (int index = 0; index < (Long) $.get(data, "page.batchSize"); index += 1) {
            String id = (String) $.get(data, "items." + index + ".id");
            String linkPdf = (String) $.get(data, "items." + index + ".linkPDF");
            callables.add(new CallableImpl(this, id, linkPdf));
        }
        try {
            for (Future<Map<String, Object>> future : executor.invokeAll(callables)) {
                result.add(future.get());
            }
        } catch (ExecutionException ex) {
        } catch (InterruptedException ex) {
        }
        executor.shutdown();
        return result;
    }

    @Override
    public Map<String, Object> getDeclaration(String id) {
        return $.last((List<Map<String, Object>>) get("/" + id).json());
    }

    @Override
    public String getDeclarationHtml(String id) {
        return $.fetch(BASE_URL_HTML + id).text();
    }

    public static void main(String ... args) {
        final String message = "Java client for declarations from the nazk.gov.ua.\n\n"
            + "For docs, license, tests, and downloads, see: https://github.com/javadev/nazk-client";
        System.out.println(message);
    }
}
