package com.algorithm.baekjoon.problem;

public class P1000 implements BaekjoonProblem {
    public String solution(String input) {
        String[] inputs = input.split(" ");
        int a = Integer.parseInt(inputs[0]);
        int b = Integer.parseInt(inputs[1]);
        return String.valueOf(a + b);
    }
}
