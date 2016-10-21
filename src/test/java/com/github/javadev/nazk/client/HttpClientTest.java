package com.github.javadev.nazk.client;

import java.util.Map;
import com.github.underscore.lodash.$;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HttpClientTest {
    private static NazkClient client = HttpClient.createDefault();

    @Test
    public void getDeclarations() throws Exception {
        Map<String, Object> declarations = client.getDeclarations("");
        assertEquals("1", $.get(declarations, "page.currentPage").toString());
        assertEquals("400", $.get(declarations, "page.batchSize").toString());
    }

    @Test
    public void getDeclaration() throws Exception {
        Map<String, Object> declarations = client.getDeclarations("");
        String id = (String) $.get(declarations, "items.0.id");
        Map<String, Object> declaration = client.getDeclaration(id);
        assertEquals("1", $.get(declaration, "data.step_0.declarationType").toString());
    }

    @Test
    public void main() {
        HttpClient.main("test");
    }
}
