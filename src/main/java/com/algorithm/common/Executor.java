package com.algorithm.common;

import com.algorithm.baekjoon.problem.BaekjoonProblem;
import com.algorithm.common.component.ResourceHandler;
import com.algorithm.common.convertor.ProblemNameConvertor;
import com.algorithm.common.domain.entity.QuestionEntity;
import com.algorithm.common.parser.BaekjoonSampleParser;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Executor {
    public static void execute(Class<? extends BaekjoonProblem> problem) throws Exception {
        String problemClassName = problem.getSimpleName();
        System.out.println(problemClassName);
        String problemNumber    = ProblemNameConvertor.getProblem(problemClassName);

        /** 예시 데이터 조회 **/
        if(!ResourceHandler.isParseSampleData(problemNumber)) {
            BaekjoonSampleParser sampleParser = new BaekjoonSampleParser();
            sampleParser.parse(problemNumber);
        }

        /** 답안 실행 **/
        BaekjoonProblem P1 = problem.getDeclaredConstructor().newInstance();
        Method solution = problem.getMethod("solution", String.class);

        /** 테스트 데이터 읽기 **/
        Map<Integer, QuestionEntity> testCaseMap = new HashMap<>();
        ResourceHandler.listFileNames(problemNumber).forEach(fileName -> {

            String testCase = ResourceHandler.readFromFile(problemNumber, fileName);

            String[] parts = fileName.split("-");
            String type = parts[0]; // input or output
            Integer idx  = Integer.parseInt(parts[2].replace(".txt", ""));

            if(!testCaseMap.containsKey(idx))
                testCaseMap.put(idx, new QuestionEntity());

            QuestionEntity testCaseEntity = testCaseMap.get(idx);

            switch(type) {
                case "INPUT" -> {
                    testCaseEntity.setInput(testCase);
                }
                case "OUTPUT" -> {
                    testCaseEntity.setOutput(testCase);
                }
                default -> System.out.println(">>> Unknown Data");
            }
        });


        for(Map.Entry<Integer, QuestionEntity> entry : testCaseMap.entrySet()) {
            Integer idx = entry.getKey();
            QuestionEntity question = entry.getValue();

            long startTime = System.nanoTime();
            String result = (String) solution.invoke(P1, question.getInput());
            long endTime = System.nanoTime();

            String status = result.equals(question.getOutput()) ? "Correct" : "Fail";

            System.out.printf("Test Case %d: %s\n", idx, status);
            System.out.println("Expected: " + question.getOutput());
            System.out.println("Got     : " + result);
            System.out.printf("Execution Time: %.3f ms\n", (endTime - startTime) / 1_000_000.0);
            System.out.println("--------------------------------------------------");

        }
    }
}
