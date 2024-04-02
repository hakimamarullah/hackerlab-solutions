package com.solution.hackerrank.problems;
/*
IntelliJ IDEA 2022.2.2 (Community Edition)
Build #IC-222.4167.29, built on September 13, 2022
Runtime version: 17.0.4+7-b469.53 amd64
@Author hakim a.k.a. Hakim Amarullah
Java Developer
Created on 4/2/2024 11:47 AM
@Last Modified 4/2/2024 11:47 AM
Version 1.0
*/

import com.solution.hackerrank.Solution;
import com.solution.hackerrank.utility.TestCaseUtil;

import java.util.Scanner;

public class Fisherman implements Solution<Void> {
    int n, ans;
    boolean[] visited;
    Gate[] gates;

    @Override
    public Void answer() throws Exception {
        Scanner scanner = TestCaseUtil.getInputScanner("test_cases/fisherman_tc_1.txt");
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            gates = new Gate[4];
            for (int i = 1; i <= 3; i++) {
                int loc = scanner.nextInt();
                int men = scanner.nextInt();
                gates[i] = new Gate(loc, men);
            }

            visited = new boolean[100];
            ans = Integer.MAX_VALUE;

            solve(1, 2, 3, 0, 1);
            solve(1, 3, 2, 0, 1);
            solve(2, 1, 3, 0, 2);
            solve(2, 3, 1, 0, 2);
            solve(3, 1, 2, 0, 3);
            solve(3, 2, 1, 0, 3);

            System.out.println(ans);
        }
        scanner.close();
        return null;
    }

    static class Gate {
        int loc, men;

        Gate(int loc, int men) {
            this.loc = loc;
            this.men = men;
        }
    }

    int findLeft(int index) {
        for (int i = index; i > 0; i--) {
            if (!visited[i]) {
                return i;
            }
        }
        return Integer.MAX_VALUE;
    }

    int findRight(int index) {
        for (int i = index + 1; i <= n; i++) {
            if (!visited[i]) {
                return i;
            }
        }
        return Integer.MAX_VALUE;
    }

    void solve(int x, int y, int z, int distance, int cur_gate) {
        if (distance > ans) return;

        if (gates[cur_gate].men == 0) {
            if (cur_gate == x) cur_gate = y;
            else if (cur_gate == y) cur_gate = z;
            else {
                ans = Math.min(ans, distance);
                return;
            }
        }

        int l = findLeft(gates[cur_gate].loc);
        int r = findRight(gates[cur_gate].loc);

        int costL = Math.abs(gates[cur_gate].loc - l) + 1;
        int costR = Math.abs(gates[cur_gate].loc - r) + 1;

        boolean goRight = costL > costR;
        boolean goLeft = costR > costL;

        if (goLeft) {
            visited[l] = true;
            gates[cur_gate].men--;
            solve(x, y, z, distance + costL, cur_gate);
            visited[l] = false;
            gates[cur_gate].men++;
        }

        if (goRight) {
            visited[r] = true;
            gates[cur_gate].men--;
            solve(x, y, z, distance + costR, cur_gate);
            visited[r] = false;
            gates[cur_gate].men++;
        }
    }
}
