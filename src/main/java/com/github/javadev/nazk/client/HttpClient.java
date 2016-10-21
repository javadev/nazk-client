package com.github.javadev.nazk.client;

import com.github.underscore.lodash.$;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpClient implements NazkClient {
    private static final String BASE_URL = "https://public-api.nazk.gov.ua/v1/declaration";

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

    @Override
    public Map<String, Object> getDeclaration(String id) {
        return $.last((List<Map<String, Object>>) get("/" + id).json());
    }

    public static void main(String ... args) {
        final String message = "Java client for declarations from the nazk.gov.ua.\n\n"
            + "For docs, license, tests, and downloads, see: https://github.com/javadev/nazk-client";
        System.out.println(message);
    }
}
