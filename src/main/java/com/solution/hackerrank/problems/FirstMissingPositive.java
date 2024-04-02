package com.solution.hackerrank.problems;
/*
IntelliJ IDEA 2022.2.2 (Community Edition)
Build #IC-222.4167.29, built on September 13, 2022
Runtime version: 17.0.4+7-b469.53 amd64
@Author hakim a.k.a. Hakim Amarullah
Java Developer
Created on 4/1/2024 10:53 PM
@Last Modified 4/1/2024 10:53 PM
Version 1.0
*/

import com.solution.hackerrank.Solution;

public class FirstMissingPositive implements Solution<Void> {

    private int firstMissingPositive(int[] array) {
        for(int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                array[i] = 0;
            }
        }

        for (int i = 0; i < array.length; i++) {
            int val = Math.abs(array[i]);
            if (val >= 1 && val <= array.length) {
                if (array[val - 1] > 0) {
                    array[val - 1] *= -1;
                } else if (array[val - 1] == 0) {
                    array[val - 1] = -1 * (array.length + 1);
                }
            }
        }

        for (int i = 1; i < array.length + 1; i++) {
            if (array[i - 1] >= 0) {
                return i;
            }
        }
        return array.length + 1;
    }
    @Override
    public Void answer() throws Exception {
        System.out.println(firstMissingPositive(new int[]{2, -1, 0}));
        return null;
    }


}
