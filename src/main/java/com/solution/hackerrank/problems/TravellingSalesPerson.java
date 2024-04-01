package com.solution.hackerrank.problems;
/*
IntelliJ IDEA 2022.2.2 (Community Edition)
Build #IC-222.4167.29, built on September 13, 2022
Runtime version: 17.0.4+7-b469.53 amd64
@Author hakim a.k.a. Hakim Amarullah
Java Developer
Created on 4/1/2024 6:48 PM
@Last Modified 4/1/2024 6:48 PM
Version 1.0
*/

import com.solution.hackerrank.Solution;
import com.solution.hackerrank.utility.TestCaseReader;

import java.io.IOException;
import java.util.Scanner;

public class TravellingSalesPerson implements Solution<Void> {

    @Override
    public Void answer() throws Exception {
        Scanner in = TestCaseReader.getInputScanner("test_cases/traveling_sales_person_tc_1.txt");
        int T = in.nextInt();
        int[][] cost;

        while (T-- > 0) {
            int N = in.nextInt();
            cost = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int element = in.nextInt();
                    cost[i][j] = element;
                }
            }

            System.out.println(CFG.minCost(cost));
        }
        return null;
    }
}

class CFG {
    static int[][] graph;
    static int N;

    private static int tsp(int mask, int pos) {
        if (mask == (1 << N) - 1) {
            return graph[pos][0];
        }

        int minCost = Integer.MAX_VALUE;

        for (int city = 0; city < N; city++) {
            if ((mask & (1 << city)) == 0) {
                int newCost = graph[pos][city] + tsp(mask | (1 << city), city);
                minCost = Math.min(minCost, newCost);
            }
        }
        return minCost;
    }

    public static int minCost(int[][] cost) {
        N = cost.length;
        graph = cost;
        return tsp(1, 0);
    }


}
