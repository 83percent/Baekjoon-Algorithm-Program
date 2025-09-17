package com.algorithm.baekjoon.problem;

public class P1002 implements BaekjoonProblem {
    public String solution(String input) {
        StringBuilder sb = new StringBuilder();
        String[] lines = input.split("\n");
        int questions = Integer.parseInt(lines[0]);

        for(int i = 1; i <= questions; i++) {
            String[] vArr = lines[i].split(" ");
            int x1 = Integer.parseInt(vArr[0]);
            int y1 = Integer.parseInt(vArr[1]);
            int r1 = Integer.parseInt(vArr[2]);
            int x2 = Integer.parseInt(vArr[3]);
            int y2 = Integer.parseInt(vArr[4]);
            int r2 = Integer.parseInt(vArr[5]);

            if(x1 == x2 && y1 == y2) {
                if(r1 == r2)
                    sb.append(-1).append("\n");
                else
                    sb.append(0).append("\n");
                continue;
            }

            int width   = x1 < x2 ? Math.abs(x2 - x1) : Math.abs(x1 - x2);
            int height  = y1 < y2 ? Math.abs(y2 - y1) : Math.abs(y1 - y2);

            int suggestedR = r1 + r2;
            double realR      = width == 0 || height == 0
                                ? width == 0 ? height : width
                                : Math.sqrt((width * width) + (height + height));

            if(realR > suggestedR)
                sb.append(0).append("\n");
            else if(realR == suggestedR)
                sb.append(1).append("\n");
            else
                sb.append(2).append("\n");

        }

        return sb.toString().trim();
    }
}
