package com.example.genai;


import dev.langchain4j.model.azure.AzureOpenAiChatModel;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;

public class DialApiExample {
    public static void main(String[] args) {

        String apiKey = System.getenv("DIAL_API_KEY");

        ChatLanguageModel model = AzureOpenAiChatModel.builder()
                .apiKey(apiKey)
                .endpoint("https://ai-proxy.lab.epam.com") // ✅ NO /v1 here
                .deploymentName("gpt-4") // ✅ important (not modelName)
                .build();

        String prompt = "Explain technical debt in one sentence.";

        String response = model.generate(prompt);

        System.out.println(response);

        // Test 1: Basic API call
        testBasic(model);
        //Test 2: Advanced Classifier
        testClassifier(model);
        //Test 3: Logic Solver
        testLogic(model);
        //Test 4: Code Generator
        testCodeGenerator(model);
        //Test 5: Email Parser
        testEmailParser(model);
    }


    static void testBasic(ChatLanguageModel model) {
        System.out.println("🔹 Test 1: Basic Prompt");

        String response = model.generate("Explain technical debt in one sentence.");
        System.out.println(response + "\n");
    }


    static void testClassifier(ChatLanguageModel model) {
        System.out.println("🔹 Test 2: Advanced Classifier");

        System.out.println(
                AdvancedClassifier.classifyAndPrioritize(
                        model,
                        "App crashes when clicking login button"
                )
        );
        System.out.println();
    }

    static void testLogic(ChatLanguageModel model) {
        System.out.println("🔹 Test 3: Logic Solver");

        String puzzle = "Four friends, Alex, Ben, Chris, and David are standing in a line. Chris is not at either end. Ben is directly in front of Alex. David is somewhere behind Chris.";

        System.out.println(
                LogicProblemSolver.solve(puzzle, model)
        );
        System.out.println();
    }

    static void testCodeGenerator(ChatLanguageModel model) {
        System.out.println("🔹 Test 4: Code Generator");

        System.out.println(
                CodeGenerator.generateCode(
                        model,
                        "Create a function calculateAverage that takes list of numbers and returns average"
                )
        );
        System.out.println();
    }

    static void testEmailParser(ChatLanguageModel model) {
        System.out.println("🔹 Test 5: Email Parser");

        System.out.println(
                ResilientEmailParser.parseEmailBody(
                        model,
                        "Hi, this is Senthiya Prabha. You can contact me at senthiya_periyasamy@epam.com or call me at 985353. Thanks."
                )
        );
        System.out.println();
    }



}
