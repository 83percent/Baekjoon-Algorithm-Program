package com.algorithm.baekjoon.export;

import java.io.*;
import java.util.*;

public class Sample { // TODO : 클래스명을 Main으로 변경해야한다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            sb.append(line).append("\n");
        }
        String input = sb.toString().trim();
        String result = solution(input);
        System.out.print(result);
    }

    private static int[] memory;

    public static String solution(String input) {
        StringBuilder sb = new StringBuilder();
        String[] lines = input.split("\n");
        String[] firstLine = lines[0].split(" ");
        int totalNumber = Integer.parseInt(firstLine[0]);
        int inputLineCount = Integer.parseInt(firstLine[1]);

        memory = new int[totalNumber + 1];
        for(int i = 0; i < totalNumber + 1; i++) memory[i] = i;

        for(int i = 1; i <= inputLineCount; i++) {
            String[] line = lines[i].split(" ");
            int target1 = Integer.parseInt(line[1]);
            int target2 = Integer.parseInt(line[2]);
            switch(line[0]) {
                /// union-find
                case "0" -> {
                    if(target1 == target2) continue;
                    int target  = Math.min(target1, target2);
                    int goal    = Math.max(target1, target2);

                    union(target, goal);
                }

                /// result
                case "1" -> {
                    if(find(target1) == find(target2))
                        sb.append("YES");
                    else
                        sb.append("NO");

                    sb.append("\n");

                }
            }
        }

        return sb.toString().trim();
    }

    private static void union(int target, int goal) {
        memory[target] = goal;
    }

    private static int find(int target) {
        if(memory[target] == target) {
            return target;
        } else {
            int groupNumber = find(memory[target]);
            memory[target] = groupNumber;
            return groupNumber;
        }
    }
}
