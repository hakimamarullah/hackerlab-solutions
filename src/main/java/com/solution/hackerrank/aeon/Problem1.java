package com.solution.hackerrank.aeon;
/*
@Author hakim a.k.a. Hakim Amarullah
Java Developer
Created on 5/30/2024 2:08 PM
@Last Modified 5/30/2024 2:08 PM
Version 1.0
*/

import java.util.HashSet;
import java.util.Set;

public class Problem1 {
    

    public boolean solution(int[] array, int k) {
        Set<Integer> complements = new HashSet<>();

        // Time complexity O(n)
        for (int x : array) {
            int nextNum = k - x;

            // method contains of Java's Set has time complexity of O(1)
            if (complements.contains(nextNum)) {
                return true;
            }

            // O(1)
            complements.add(x);
        }
        return false;
    }
}
