package com.solution.hackerrank.quicksolve;
/*
@Author hakim a.k.a. Hakim Amarullah
Java Developer
Created on 5/20/2024 11:17 PM
@Last Modified 5/20/2024 11:17 PM
Version 1.0
*/

import java.util.*;

public class BukuWarungInterview {

    public static void main(String[] args) {
        System.out.println(subArraySum(new int[]{1,2,3}, 3));
    }

    public static int[] twoSum(int[] arr, int target) {
        Map<Integer, Integer> complements = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int nextNum = target - arr[i];

            if (complements.containsKey(nextNum)) {
                return new int[]{complements.get(nextNum), i};
            }
            complements.put(arr[i], i);
        }

        return new int[]{};
    }

    public static boolean canMakePalindrome(String input) {
        Map<Character, Integer> occurrence = new HashMap<>();

        for (char x : input.toCharArray()) {
            occurrence.put(x, occurrence.getOrDefault(x, 0) + 1);
        }

        return occurrence.values().stream().filter(val -> val % 2 != 0).count() <= 1;
    }

    public static int[] mergeTwoSortedArray(int[] a, int[] b) {
        int[] merged = new int[a.length + b.length];
        Arrays.fill(merged, 0);

        int i =0, j = 0, k = 0;

        while(i < a.length && j < b.length) {
           if (a[i] <= b[j]) {
               merged[k++] = a[i++];
           } else {
               merged[k++] = b[j++];
           }
        }

        while(i < a.length) {
            merged[k++] = a[i++];
        }

        while (j < b.length) {
            merged[k++] = b[j++];
        }
        return merged;
    }

    public static int longestNonDuplicateSubstring(String input) {
        int i = 0;
        int j = 0;
        int max = 0;
        Set<Character> tracker = new HashSet<>();

        while(j < input.length()) {
            if (!tracker.contains(input.charAt(j))) {
                tracker.add(input.charAt(j++));
                max = Math.max(j - i, max);
            } else {
                tracker.remove(input.charAt(i));
                i++;
            }
        }
        return max;
    }

    public static int findDuplicateNumber(int[] arr) {
        int tortoise = arr[0];
        int hare = arr[0];
        do {
            tortoise = arr[tortoise];
            hare = arr[arr[hare]];
        } while (tortoise != hare);


        tortoise = arr[0];
        while (tortoise != hare) {
            tortoise = arr[tortoise];
            hare = arr[hare];
        }
        return tortoise;
    }

    public static int subArraySum(int[] nums, int k) {
        // HashMap to store the cumulative sum and the number of times it occurs
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // To handle the case when the subarray starts from index 0

        int cumulativeSum = 0;
        int count = 0;

        for (int num : nums) {
            cumulativeSum += num;

            // Check if there is a cumulative sum that equals current cumulativeSum - k
            if (map.containsKey(cumulativeSum - k)) {
                count += map.get(cumulativeSum - k);
            }

            // Update the map with the current cumulative sum
            map.put(cumulativeSum, map.getOrDefault(cumulativeSum, 0) + 1);
        }

        return count;
    }
}
