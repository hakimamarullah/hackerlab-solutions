package com.solution.hackerrank;

import lombok.extern.slf4j.Slf4j;

import java.util.Deque;
import java.util.LinkedList;

@Slf4j
public class Runner {
    public static void main(String[] args) {
        try{
            System.out.println(maximumSumSubarray(new int[]{5, 0, 8, 0, 0, 2, 4, 8, 0, 6, 9, 4}, 12, 2));
        } catch (Exception e) {
            log.error("[SOLUTION ERROR]{}", e.getMessage(), e);
        }
    }

    static int maximumSumSubarray(int arr[], int n, int L) {
        int res = Integer.MIN_VALUE;
        int prefix_sum[] = new int[n];
        prefix_sum[0] = arr[0];
        for (int i = 1; i < n; i++)
            prefix_sum[i] = prefix_sum[i - 1] + arr[i];

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (!deque.isEmpty() && i - deque.peekFirst() > L) {
                deque.pollFirst();
            }
            if (!deque.isEmpty()) {
                res = Math.max(res, prefix_sum[i] - prefix_sum[deque.peekFirst()]);
            }
            while (!deque.isEmpty() && prefix_sum[i] <= prefix_sum[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        return res;
    }







}