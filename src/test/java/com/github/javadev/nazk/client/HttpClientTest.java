package com.github.javadev.nazk.client;

import java.util.List;
import java.util.Map;
import com.github.underscore.lodash.$;
import org.junit.Test;
import org.junit.Ignore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HttpClientTest {
    private static NazkClient client = HttpClient.createDefault();

    @Test
    public void getDeclarations() {
        Map<String, Object> declarations = client.getDeclarations("");
        assertEquals("1", $.get(declarations, "page.currentPage").toString());
        assertEquals("400", $.get(declarations, "page.batchSize").toString());
    }

    @Test
    public void getDeclaration() {
        Map<String, Object> declaration = client.getDeclaration("043c6b5d-a470-4fb0-bc3b-3332af7fe10e");
        assertEquals("1", $.get(declaration, "data.step_0.declarationType").toString());
        assertEquals("[Конфіденційна інформація]", $.get(declaration, "data.step_1.street").toString());
    }

    @Test
    public void getDeclarationHtml() {
        String declaration = client.getDeclarationHtml("043c6b5d-a470-4fb0-bc3b-3332af7fe10e");
        assertTrue(declaration.startsWith("<!DOCTYPE html><html lang=\"en\"><head> "
            + "<meta charset=\"utf-8\"> <title>Перегляд декларації"));
    }

    @Test
    @Ignore
    public void getDeclarationPdf() {
        byte[] data = $.fetch("https://public.nazk.gov.ua/storage/documents/pdf/"
            + "5/0/e/e/50ee7eae-f4ee-4b5c-b67d-9917154f7c53.pdf").blob();
        assertTrue(data.length > 10000);
    }

    @Test
    public void getDeclarationsBatch() {
        List<Map<String, Object>> declarationsBatch = client.getDeclarationsBatch("", 0);
        assertTrue("declarationsBatch.size() should be more than 10", declarationsBatch.size() > 10);
    }

    @Test 
    public void getAndSaveAllDeclarations() {
        client.getAndSaveAllDeclarations("", "test", 1);
    }

    @Test
    public void main() {
        HttpClient.main(new String[] {});
    }
}
