package com.solution.hackerrank.problems;
/*
IntelliJ IDEA 2022.2.2 (Community Edition)
Build #IC-222.4167.29, built on September 13, 2022
Runtime version: 17.0.4+7-b469.53 amd64
@Author hakim a.k.a. Hakim Amarullah
Java Developer
Created on 3/29/2024 7:45 AM
@Last Modified 3/29/2024 7:45 AM
Version 1.0
*/

import com.solution.hackerrank.Solution;
import com.solution.hackerrank.utility.TestCaseUtil;

import java.io.IOException;
import java.util.*;

public class DequeMaxUniqueNumberSubArray implements Solution<Void> {

    public static void main(String[] args) throws IOException {


    }





    @Override
    public Void answer() throws Exception {
        Scanner in = TestCaseUtil.getInputScanner("test_cases/max_unique_number_sub_array_tc_1.txt");
        Deque<Integer> deque = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        int n = in.nextInt();
        int m = in.nextInt();

        int max = 0;
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.addLast(num);
            set.add(num);

            if (deque.size() == m) {
                int first = deque.removeFirst();
                max = Math.max(max, set.size());
                if (!deque.contains(first)) {
                    set.remove(first);
                }
            }

        }

        System.out.println(max);
        return null;
    }
}
