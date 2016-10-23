package com.github.javadev.nazk.client;

import java.util.List;
import java.util.Map;

public interface NazkClient {
    Map<String, Object> getDeclarations(String queryString);

    Map<String, Object> getDeclaration(String id);

    String getDeclarationHtml(String id);

    List<Map<String, Object>> getDeclarationsBatch(int page);

    void getAndSaveAllDeclarations(String directoryName, int maxPages);
}
