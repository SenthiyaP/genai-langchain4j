package com.example.genai;

public class PromptTemplates {
    public static String createSummaryPrompt(String text, String audience, String style) {
        return String.format(
                "Summarize the following text for a '%s' audience.\n" +
                        "The summary should be written in a '%s' style.\n\nText:\n---\n%s\n---\n\nSummary:",
                audience, style, text
        );
    }

}
