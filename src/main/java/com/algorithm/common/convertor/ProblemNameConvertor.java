package com.algorithm.common.convertor;

import com.algorithm.common.component.PropertiesReader;

public class ProblemNameConvertor {
    private static final String PROBLEM_PREFIX;
    static {
        PROBLEM_PREFIX = PropertiesReader.get("problem.prefix");
    }

    /**
     * <pre>Class Name 으로부터 문제번호 추출</pre>
     * @param className Class Name
     * @return 문제 번호
     */
    public static String getProblem(String className) {
        if(!className.contains(PROBLEM_PREFIX)) throw new IllegalArgumentException("Invalid class name: " + className);
        return className.replace(PROBLEM_PREFIX, "");
    }

    /**
     * <pre>문제번호로부터 Class Name 추출</pre>
     * @param problem 문제번호
     * @return Class Name
     */
    public static String getClassName(String problem) {
        return PROBLEM_PREFIX + problem;
    }

}
