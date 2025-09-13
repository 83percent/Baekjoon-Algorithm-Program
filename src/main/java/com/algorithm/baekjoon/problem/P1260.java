package com.algorithm.baekjoon.problem;

import java.util.*;

public class P1260 implements BaekjoonProblem {

    private Map<Integer, List<Integer>> graph;

    public String solution(String input) {
        StringBuilder result = new StringBuilder();
        String[] lines = input.split("\n");

        String[] firstLine = lines[0].split(" ");
        int vertexCount  = Integer.parseInt(firstLine[0]);
        int node         = Integer.parseInt(firstLine[1]);
        int startVertex  = Integer.parseInt(firstLine[2]);


        this.convertGraph(Arrays.copyOfRange(lines, 1, lines.length));



        result.append(this.DFS(vertexCount, startVertex));
        result.append("\n");
        result.append(this.BFS(vertexCount, startVertex));

        return result.toString();
    }

    private void convertGraph(String[] edges) {
        graph = new HashMap<>();

        for(String edge : edges) {
            String[] vertex = edge.split(" ");
            Integer  v1     = Integer.parseInt(vertex[0]);
            Integer  v2     = Integer.parseInt(vertex[1]);

            if(!graph.containsKey(v1)) graph.put(v1, new ArrayList<>());
            graph.get(v1).add(v2);

            if(!graph.containsKey(v2)) graph.put(v2, new ArrayList<>());
            graph.get(v2).add(v1);

        }

        this.graph.forEach((vertex, nodeList) -> {
            nodeList.sort(Comparator.naturalOrder());
        });

    }

    private String DFS(int vertexCount, int start) {
        StringBuilder result = new StringBuilder();

        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        boolean[] visitMemory = new boolean[vertexCount + 1];
        Arrays.fill(visitMemory, false);
        visitMemory[start] = true;

        while(!stack.isEmpty()) {
            int startVertex = stack.pop();
            result.append(startVertex).append(" ");

            for(int endVertex : this.graph.get(startVertex)) {
                if(visitMemory[endVertex]) continue;
                stack.push(endVertex);
                visitMemory[endVertex] = true;
                break;
            }
        }

        return result.toString().trim();
    }

    private String BFS(int vertexCount, int start) {
        StringBuilder result = new StringBuilder();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        boolean[] visitMemory = new boolean[vertexCount + 1];
        Arrays.fill(visitMemory, false);
        visitMemory[start] = true;

        while(!queue.isEmpty()) {
            int startVertex = queue.poll();
            result.append(startVertex).append(" ");

            for(Integer endVertex : this.graph.get(startVertex)) {
                if(!visitMemory[endVertex]) {
                    queue.add(endVertex);
                    visitMemory[endVertex] = true;
                }
            }
        }

        return result.toString().trim();
    }



}
