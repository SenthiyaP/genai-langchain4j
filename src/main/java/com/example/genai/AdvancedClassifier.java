package com.example.genai;

import dev.langchain4j.model.chat.ChatLanguageModel;

public class AdvancedClassifier {

    public static String classifyAndPrioritize(ChatLanguageModel model, String ticket) {

        String prompt =
                "Classify the support ticket into Bug, Feature Request, Question, Praise, or Complaint " +
                        "and assign priority Low, Medium, or High.\n\n" +

                        "Ticket: \"App crashes when clicking login\"\n" +
                        "Output: {\"category\":\"Bug\",\"priority\":\"High\"}\n\n" +

                        "Ticket: \"Can you add dark mode?\"\n" +
                        "Output: {\"category\":\"Feature Request\",\"priority\":\"Low\"}\n\n" +

                        "Ticket: \"" + ticket + "\"\nOutput:";

        return model.generate(prompt);
    }

}
