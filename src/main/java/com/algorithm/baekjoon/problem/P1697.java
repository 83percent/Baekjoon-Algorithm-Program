package com.algorithm.baekjoon.problem;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class P1697 implements BaekjoonProblem {

    @Override
    public String solution(String input) {
        String[] line = input.split(" ");
        int startPosition = Integer.parseInt(line[0]);
        int goal          = Integer.parseInt(line[1]);

        /// 현재위치 보다 목표위치가 더 작은 경우, '뒤로 걷기 (현재위치-1)'만 가능하다.
        if(startPosition >= goal) return String.valueOf(startPosition - goal);

        Map<Integer, Integer> visitMemory = new HashMap<>();
        visitMemory.put(startPosition, 0);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(startPosition);

        while(!queue.isEmpty()) {
            int position = queue.poll();
            int time     = visitMemory.get(position) + 1;

            /// +1
            if(visitMemory.containsKey(position + 1)) {
                if(time < visitMemory.get(position + 1)) {
                    visitMemory.put(position + 1, time);
                }
            } else {
                visitMemory.put(position + 1, time);
                if(position + 1 < goal) queue.add(position + 1);
            }

            /// -1
            if(visitMemory.containsKey(position - 1)) {
                if(time < visitMemory.get(position - 1)) {
                    visitMemory.put(position - 1, time);
                }
            } else {
                visitMemory.put(position - 1, time);
                if(position - 1 > 0) queue.add(position - 1);
            }

            /// *2
            if(visitMemory.containsKey(position * 2)) {
                if(time < visitMemory.get(position * 2)) {
                    visitMemory.put(position * 2, time);
                }
            } else {
                visitMemory.put(position * 2, time);
                if(position * 2 < goal / 2 + goal) queue.add(position * 2);
            }

            if(visitMemory.containsKey(goal)) {
                break;
            }

        }

        return String.valueOf(visitMemory.get(goal));
    }




}
