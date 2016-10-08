package com.github.javadev.nazk.client;

import java.util.Map;

public interface NazkClient {
    Map<String, Object> getDeclarations(String queryString);

    Map<String, Object> getDeclaration(String id);
}
