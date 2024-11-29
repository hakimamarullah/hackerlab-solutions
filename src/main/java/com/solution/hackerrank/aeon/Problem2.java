package com.solution.hackerrank.aeon;
/*
@Author hakim a.k.a. Hakim Amarullah
Java Developer
Created on 5/30/2024 2:16 PM
@Last Modified 5/30/2024 2:16 PM
Version 1.0
*/

public class Problem2 {


    // Time complexity O(n); Space complexity O(n)
    public int[] solution(int[] array) {
        int n = array.length;
        int[] result = new int[n];



        // Calculate prefix product (left part of the current element at i)
        int prefixProduct = 1;
        for(int i = 0; i < n; i++) {
            result[i] = prefixProduct;
            prefixProduct *= array[i];
        }


        // Calculate suffixProduct and multiply them with current prefixProduct as stored in array result
        int suffixProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= suffixProduct;
            suffixProduct *= array[i];
        }
        return result;
    }
}
