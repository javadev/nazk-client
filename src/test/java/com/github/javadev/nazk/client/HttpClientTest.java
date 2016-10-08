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
        assertEquals("", declarations.toString());
    }

    @Test
    public void main() {
        HttpClient.main("test");
    }
}
