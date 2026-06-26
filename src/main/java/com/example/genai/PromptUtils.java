package com.example.genai;

import dev.langchain4j.model.chat.ChatLanguageModel;

public class PromptUtils {

    public static String getCompletion(ChatLanguageModel model, String prompt) {
        return model.generate(prompt);
    }

}
