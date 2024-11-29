package com.solution.hackerrank.aeon;
/*
@Author hakim a.k.a. Hakim Amarullah
Java Developer
Created on 5/30/2024 4:05 PM
@Last Modified 5/30/2024 4:05 PM
Version 1.0
*/

public class Problem5 {

    public static void main(String[] args) {
        System.out.println(solution(7));
    }

    // Time complexity O(N)
    // Assumptions N >= 0
    public static int solution(int N) {
        char[] binary = Integer.toBinaryString(N).toCharArray();
        int maxGap = 0;
        int currentGap = 0;
        boolean inGap = false;

        for (char bit : binary) {
            if (bit == '1') {
                if (inGap) {
                    maxGap = Math.max(maxGap, currentGap);
                }
                inGap = true;
                currentGap = 0;
            } else if (inGap) {
                currentGap++;
            }
        }

        return maxGap;
    }
}
