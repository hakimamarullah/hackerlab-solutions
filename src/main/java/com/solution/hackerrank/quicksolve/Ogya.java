package com.solution.hackerrank.quicksolve;
/*
@Author hakim a.k.a. Hakim Amarullah
Java Developer
Created on 5/4/2024 1:25 PM
@Last Modified 5/4/2024 1:25 PM
Version 1.0
*/

import java.util.HashMap;
import java.util.Map;

public class Ogya {

    public static void main(String[] args) {
        int[] a = new int[]{4,6,1,3,1,5};

        for (int i = a.length - 2; i >= 0; i--) {
            a[i] = a[i] + a[i+1];
        }

        for (int j : a) {
            System.out.print(j + " ");
        }

    }

    static void printFibo(int n) {
        int a = 0, b = 1;
        System.out.print(a + " " + b + " ");
        for (int i = 0; i < n; i++) {
            int c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
    }

    static void printTri(int n) {
        for (int i = n; i >= 0; i--) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void printTriLeft(int n) {
        for (int i = 1; i <= n; i++) {

            for (int j = 0; j < 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static boolean makePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char x: s.toCharArray()) {
           map.put(x, map.getOrDefault(x, 0) + 1);
        }

        return map.values().stream().filter(x -> x % 2 != 0).count() <= 1;

    }

    static void printTriRight(int n) {
        int space = n * 2;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < space ; j++) {
                System.out.print(" ");
            }
            space -= 2;
            for (int j = 0; j < 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

class A {
    void printMe(A a) {
        System.out.println("A");
    }
}

class B extends A {
    void printMe(B b) {
        System.out.println("B");
    }
}

class C extends B {
    void printMe(C c) {
        System.out.println("C");
    }
}

class D extends C {
    void printMe(D d) {
        System.out.println("D");
    }
}
