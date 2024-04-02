package com.solution.hackerrank.problems;
/*
IntelliJ IDEA 2022.2.2 (Community Edition)
Build #IC-222.4167.29, built on September 13, 2022
Runtime version: 17.0.4+7-b469.53 amd64
@Author hakim a.k.a. Hakim Amarullah
Java Developer
Created on 4/1/2024 9:07 PM
@Last Modified 4/1/2024 9:07 PM
Version 1.0
*/

import com.solution.hackerrank.Solution;
import com.solution.hackerrank.utility.TestCaseUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class KimAndRefrigerators implements Solution<Void> {

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int distance(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }

    public static int shortestPath(int N, Point[] points) {
        List<Point> allPoints = new ArrayList<>();
        allPoints.addAll(Arrays.asList(points)); // Customers

        int[][] dist = new int[N + 2][N + 2];
        for (int i = 0; i < N + 2; i++) {
            for (int j = 0; j < N + 2; j++) {
                dist[i][j] = distance(allPoints.get(i), allPoints.get(j));
            }
        }

        boolean[] visited = new boolean[N + 2];
        int[] distances = new int[N + 2];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[0] = 0;

        for (int i = 0; i < N + 2; i++) {
            int u = -1;
            for (int j = 0; j < N + 2; j++) {
                if (!visited[j] && (u == -1 || distances[j] < distances[u])) {
                    u = j;
                }
            }

            visited[u] = true;
            for (int v = 0; v < N + 2; v++) {
                if (!visited[v] && distances[u] + dist[u][v] < distances[v]) {
                    distances[v] = distances[u] + dist[u][v];
                }
            }
        }

        return distances[N + 1];
    }

    @Override
    public Void answer() throws Exception {
        Scanner sc = TestCaseUtil.getInputScanner("test_cases/kim_and_refrigerator_tc_1.txt");
        for (int i = 1; i <= 10; i++) {
            int N = sc.nextInt();
            Point[] points = new Point[N+2];
            points[0] = new Point(sc.nextInt(), sc.nextInt());
            points[N + 1] = new Point(sc.nextInt(), sc.nextInt());
            for (int j = 1; j <= N; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                points[j] = new Point(x, y);
            }

            System.out.println("#" + i + " " + shortestPath(N, points));
        }
        sc.close();
        return null;
    }
}
