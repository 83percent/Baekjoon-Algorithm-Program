package com.algorithm;

import com.algorithm.baekjoon.problem.BaekjoonProblem;
import com.algorithm.baekjoon.problem.P1007;
import com.algorithm.common.Executor;

public class Main {

    private static final Class<? extends BaekjoonProblem> PROBLEM = P1007.class;

    public static void main(String[] args) throws Exception {
        Executor.execute(PROBLEM);
    }
}