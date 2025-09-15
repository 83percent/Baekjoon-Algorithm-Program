package com.algorithm.baekjoon.problem;

public class P1717 implements BaekjoonProblem {
    private static int[] memory;

    public String solution(String input) {
        StringBuilder sb = new StringBuilder();

        String[] lines = input.split("\n");
        String[] firstLine = lines[0].split(" ");
        int totalNumber = Integer.parseInt(firstLine[0]);
        int maxLineCount = Integer.parseInt(firstLine[1]);

        // Memory Init
        memory = new int[totalNumber + 1];
        for(int i = 0; i <= totalNumber; i++) memory[i] = i;

        for(int i = 1; i <= maxLineCount; i++) {
            String[] line = lines[i].split(" ");
            String type = line[0];
            int target1 = Integer.parseInt(line[1]);
            int target2 = Integer.parseInt(line[2]);

            switch(type) {
                case "0" : {
                    if(target1 == target2) continue;
                    union(Math.min(target1, target2), Math.max(target1, target2));
                    break;
                }

                case "1" : {
                    if(find(target1) == find(target2)) {
                        sb.append("YES").append("\n");
                    } else {
                        sb.append("NO").append("\n");
                    }
                    break;
                }
            }

        }

        return sb.toString().trim();

    }

    private static void union(int t1, int t2) {
        int rootT1 = find(t1);
        int rootT2 = find(t2);

        if(rootT1 == rootT2) return;
        else if(rootT1 < rootT2) memory[rootT2] = rootT1;

    }

    private static int find(int target) {
        if(memory[target] == target) {
            return target;
        } else {
            int root = find(memory[target]);
            memory[target] = root;
            return root;
        }
    }
}
