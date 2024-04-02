package com.solution.hackerrank.problems;
/*
@Author hakim a.k.a. Hakim Amarullah
Java Developer
Created on 4/3/2024 2:11 AM
@Last Modified 4/3/2024 2:11 AM
Version 1.0
*/

import com.solution.hackerrank.Solution;
import com.solution.hackerrank.utility.TestCaseUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class MeltingIce implements Solution<Integer> {
    @Override
    public Integer answer() throws Exception {
        Scanner sc = TestCaseUtil.getInputScanner("test_cases/melting_ice_tc_2.txt");
        int t = sc.nextInt();

        while(t-- > 0) {
            int n = sc.nextInt();
            int[] ice = new int[n];

            for (int i = 0; i < n; i++) {
                ice[i] = sc.nextInt();
            }

            log.info("{}", countSeconds(ice));

        }
        sc.close();
        return null;
    }

    public static int countSeconds(int[] ice) {
        int seconds = 0;
        for (int i = 0; i < ice.length; i++) {
            if (checkAllMelted(ice)) {
                break;
            }
            for (int j = i+1; j < ice.length; j++) {
                if (j == ice.length - 1) {
                    ice[j] = 0;
                    continue;
                }
                int min = Math.min(ice[j], ice[j+1]);
                if (ice[j] != 0 && (min == ice[j])) {
                    ice[j]  -= 1;
                } else {
                    ice[j] = min;
                }

            }
            ice[i] = 0;
            seconds++;
        }
        return seconds;
    }

    private static boolean checkAllMelted(int[] ice) {
        for (int x : ice) {
            if (x != 0) {
                return false;
            }
        }
        return true;
    }
}
