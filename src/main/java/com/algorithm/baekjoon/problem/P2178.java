package com.algorithm.baekjoon.problem;

import java.util.*;

public class P2178 implements BaekjoonProblem {
    private Map<Integer, List<Integer>> graph;
    public String solution(String input) {
        String[] lines = input.split("\n");
        String[] firstLine = lines[0].split(" ");
        int width  = Integer.parseInt(firstLine[1]);
        int height = Integer.parseInt(firstLine[0]);

        return "temp";
    }

    private void convertGraph(int width, int height, String[] lines) {
        int vertexIndex = 0;

        for(int h = 0; h < height; h++) {
            for(String v : lines[h].split(" ")) {
                if("0".equals(v)) continue;
                this.graph.put(vertexIndex, new ArrayList<>());
            }
        }

        for(Integer v : this.graph.keySet()) {
            // left
            if(v - 1 >= 0) {

            }
            // right
            if(v + 1 < width) {

            }
            // up
            if(v - width >= 0) {

            }
            // down
            if(v + width < height) {

            }
        }
    }

    private String convertVertexId(Integer x, Integer y) {
        return String.join("|", String.valueOf(x), String.valueOf(y));
    }


}
