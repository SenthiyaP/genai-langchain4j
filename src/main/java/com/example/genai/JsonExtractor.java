package com.example.genai;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.langchain4j.model.chat.ChatLanguageModel;

import java.util.Map;

import static com.example.genai.PromptUtils.getCompletion;

public class JsonExtractor {
    public static Map<String, Object> extractContactJson(ChatLanguageModel model, String text) {
        String prompt = "Extract the Name, Email, and Phone from the text below and provide it as a valid JSON object. " +
                "If a field is missing, use null.\n\n" +
                "---\nText: \"Please reach out to Jane Doe at jane.d@example.com.\"\nOutput:\n" +
                "{\n  \"name\": \"Jane Doe\",\n  \"email\": \"jane.d@example.com\",\n  \"phone\": null\n}\n" +
                "---\nText: \"You can contact me, John Smith, on my mobile at (123) 456-7890. My email is j.smith@workplace.net.\"\nOutput:\n" +
                "{\n  \"name\": \"John Smith\",\n  \"email\": \"j.smith@workplace.net\",\n  \"phone\": \"(123) 456-7890\"\n}\n" +
                "---\nText: \"" + text + "\"\nOutput:";
        String response = getCompletion(model, prompt);

        // Extract JSON from response
        int jsonStart = response.indexOf('{');
        int jsonEnd = response.lastIndexOf('}') + 1;
        if (jsonStart == -1 || jsonEnd == 0) return null;
        String jsonString = response.substring(jsonStart, jsonEnd);

        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(jsonString, Map.class);
        } catch (Exception e) {
            System.out.println("Error parsing JSON: " + e.getMessage());
            return null;
        }
    }

}
