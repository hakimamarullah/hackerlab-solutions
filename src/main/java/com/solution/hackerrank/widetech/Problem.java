package com.solution.hackerrank.widetech;
/*
@Author hakim a.k.a. Hakim Amarullah
Java Developer
Created on 6/5/2024 2:16 PM
@Last Modified 6/5/2024 2:16 PM
Version 1.0
*/

import java.util.Arrays;

public class Problem {

    public static void main(String[] args) {
        int[] input = {10,9,8,7,5,6,3,2,1,-1,0};
        int[] input2 = {10,9,8,7,5,6,3,2,1,-1,0};
        int[] input3 = {10,9,8,7,5,6,3,2,1,-1,0};
        bubbleSort(input);
        bubbleSort(input2);
        bubbleSort(input3);
//        selectionSort(input2);
//        insertionSort(input3);
        System.out.println(Arrays.toString(input));
        System.out.println(Arrays.toString(input2));
        System.out.println(Arrays.toString(input3));
    }

    public static void bubbleSort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = i+1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++){
            int indexMin = i;
            for (int j = i+1; j < n; j++) {
                if (arr[indexMin] > arr[j]) {
                    indexMin = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[indexMin];
            arr[indexMin] = temp;
        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while(j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
            }

            arr[j+1] = key;
        }
    }
}
