package com.example.genai;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.langchain4j.model.chat.ChatLanguageModel;

import java.util.Map;

public class ResilientEmailParser {

    public static Map<String, Object> parseEmailBody(ChatLanguageModel model, String emailText) {

        String prompt =
                "Extract the sender's primary contact details (Name, Email, Phone) from the email. " +
                        "Ignore forwarded messages or multiple signatures. Return JSON.\n\n" +

                        "Example:\n" +
                        "Email: \"Hi, contact Jane Doe at jane@test.com\"\n" +
                        "Output: {\"name\":\"Jane Doe\",\"email\":\"jane@test.com\",\"phone\":null}\n\n" +

                        "Email: \"" + emailText + "\"\nOutput:";

        String response = model.generate(prompt);

        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(extractJson(response), Map.class);
        } catch (Exception e) {
            return null;
        }
    }

    private static String extractJson(String text) {
        int start = text.indexOf('{');
        int end = text.lastIndexOf('}') + 1;
        if (start == -1 || end == 0) return null;
        return text.substring(start, end);
    }

}
