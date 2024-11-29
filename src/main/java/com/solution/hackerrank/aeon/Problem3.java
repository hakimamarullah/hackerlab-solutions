package com.solution.hackerrank.aeon;
/*
@Author hakim a.k.a. Hakim Amarullah
Java Developer
Created on 5/30/2024 2:42 PM
@Last Modified 5/30/2024 2:42 PM
Version 1.0
*/

public class Problem3 {

    // Time complexity O(n) Space complexity: O(n)
    public int solution(int[] A) {
        int N = A.length;
        boolean[] present = new boolean[N + 1];

        // Mark the presence of elements in the array
        for (int j : A) {
            // We only consider N in range 1..100_000 as stated in the problem
            if (j > 0 && j <= N) {
                present[j] = true;
            }
        }

        // Find the first index which is not true
        for (int i = 1; i <= N; i++) {
            if (!present[i]) {
                return i;
            }
        }

        // If all indices are true, return N+1
        return N + 1;
    }
}
