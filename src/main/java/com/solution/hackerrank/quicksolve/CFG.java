package com.solution.hackerrank.quicksolve;
/*
@Author hakim a.k.a. Hakim Amarullah
Java Developer
Created on 4/6/2024 3:17 PM
@Last Modified 4/6/2024 3:17 PM
Version 1.0
*/

class CFG {

    static int maxSubArraySum(int a[], int size)
    {
        int max_so_far = Integer.MIN_VALUE,
                max_ending_here = 0,start = 0,
                end = 0, s = 0;

        for (int i = 0; i < size; i++)
        {
            max_ending_here += a[i];

            if (max_so_far < max_ending_here)
            {
                max_so_far = max_ending_here;
                start = s;
                end = i;
            }

            if (max_ending_here < 0)
            {
                max_ending_here = 0;
                s = i + 1;
            }
        }
        System.out.println(end);
        System.out.println(start);
        return (end - start + 1);
    }

    // Driver code
    public static void main(String[] args)
    {
        int[] a = {5, 0, 8, 0, 0, 2, 4, 8, 0, 6, 9, 12};
        System.out.println(indexOfMaxSubArrayValue(a, 3, 7));
        //System.out.println(maxSubArraySum(a, a.length));
    }

    public static int maxSubArrayValue(int[] a, int start, int end) {
        if (start == end) {
            return a[start];
        }
        int mid = (start + end) / 2;
        return Math.max(maxSubArrayValue(a, start, mid), maxSubArrayValue(a, mid + 1, end));
    }

    public static int indexOfMaxSubArrayValue(int[] arr, int start, int end) {
        int maxIndex = start;
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
