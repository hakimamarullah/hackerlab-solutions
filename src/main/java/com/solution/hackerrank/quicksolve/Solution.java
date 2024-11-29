package com.solution.hackerrank.quicksolve;
/*
@Author hakim a.k.a. Hakim Amarullah
Java Developer
Created on 4/6/2024 12:49 PM
@Last Modified 4/6/2024 12:49 PM
Version 1.0
*/

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0) {
            int N = sc.nextInt();
            int F = sc.nextInt();
            int K = sc.nextInt();
            int[] R = new int[N];

            for(int i = 0; i < N; i++) {
                R[i] = sc.nextInt();
            }
            System.out.println(maxProfit(12, F, K, R));
        }
        sc.close();
    }

    public static int maxProfit(int N, int F, int K, int[] R) {
        List<Pair> prices = new ArrayList<>();
        for(int i = 0; i < R.length; i++) {
            prices.add(new Pair(R[i], i));
        }

        Collections.sort(prices, Collections.reverseOrder());

        Set<Integer> usedIndex = new HashSet<>();
        int totalProfit = 0;
        for(int f = 0; f < N; f++) {
            int i = 0;
            while(i < N && usedIndex.contains(prices.get(i).index)) {
                i++;
            }

            if(i < N) {
                totalProfit = prices.get(i).price;
                usedIndex.add(prices.get(i).index);
            }
        }
        return totalProfit;
    }




    static class Pair implements Comparable<Pair> {
        int price;
        int index;

        Pair(int price, int index) {
            this.price = price;
            this.index = index;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.price, other.price);
        }
    }
}