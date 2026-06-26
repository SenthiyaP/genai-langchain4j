package com.example.genai;

import dev.langchain4j.model.chat.ChatLanguageModel;

public class LogicProblemSolver {

    public static String solve(String puzzle, ChatLanguageModel model) {

        String prompt =
                "Solve step by step:\n\n" +
                        "Q: Three people A, B, C. A is before B, B before C. Order?\n" +
                        "A: A -> B -> C\n\n" +

                        "Q: " + puzzle + "\nA:";

        return model.generate(prompt);
    }


}
