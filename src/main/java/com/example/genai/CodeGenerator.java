package com.example.genai;

import dev.langchain4j.model.chat.ChatLanguageModel;

public class CodeGenerator {

    public static String generateCode(ChatLanguageModel model, String description) {

        String prompt =
                "Generate only Java code. No explanation.\n\n" +
                        "Description: Create function add(a,b)\n" +
                        "Code: public int add(int a,int b){ return a+b; }\n\n" +
                        "Description: " + description + "\nCode:";

        return model.generate(prompt);
    }

}
