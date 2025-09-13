package com.algorithm.baekjoon.problem;

import java.util.*;

public class P2606 implements BaekjoonProblem {

    public String solution(String input) {
        String[] lines = input.split("\n");
        int computerCount = Integer.parseInt(lines[0]);

        Map<Integer, List<Integer>> graph = this.convertGraph(Arrays.copyOfRange(lines, 2, lines.length));

        int result = this.BFS(graph, 1, computerCount);
        return String.valueOf(result);
    }

    private Map<Integer, List<Integer>> convertGraph(String[] nodes) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(String node : nodes) {
            String[] v = node.split(" ");
            Integer v1 = Integer.parseInt(v[0]);
            Integer v2 = Integer.parseInt(v[1]);

            if(!graph.containsKey(v1)) graph.put(v1, new ArrayList<>());
            graph.get(v1).add(v2);

            if(!graph.containsKey(v2)) graph.put(v2, new ArrayList<>());
            graph.get(v2).add(v1);

        }

        return graph;
    }

    private int BFS(Map<Integer, List<Integer>> graph, int start, int computerCount) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        Set<Integer> visitMemory = new HashSet<>();
        visitMemory.add(start);

        while(!queue.isEmpty()) {
            int targetComputer = queue.poll();

            for(int endComputer : graph.get(targetComputer)){
                if(visitMemory.contains(endComputer)) continue;

                queue.add(endComputer);
                visitMemory.add(endComputer);
            }
        }

        return visitMemory.size() - 1;
    }


}
