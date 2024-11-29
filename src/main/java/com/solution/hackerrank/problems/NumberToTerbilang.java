package com.solution.hackerrank.problems;
/*
@Author hakim a.k.a. Hakim Amarullah
Java Developer
Created on 11/30/2024 12:06 AM
@Last Modified 11/30/2024 12:06 AM
Version 1.0
*/

public class NumberToTerbilang {

    private static final String[] ONES = { "", "satu", "dua", "tiga", "empat", "lima", "enam", "tujuh", "delapan", "sembilan" };
    private static final String[] TENS = { "", "sepuluh", "dua puluh", "tiga puluh", "empat puluh", "lima puluh", "enam puluh", "tujuh puluh", "delapan puluh", "sembilan puluh" };
    private static final String[] TEENS = { "sebelas", "dua belas", "tiga belas", "empat belas", "lima belas", "enam belas", "tujuh belas", "delapan belas", "sembilan belas" };
    private static final String[] HUNDREDS = { "", "seratus", "dua ratus", "tiga ratus", "empat ratus", "lima ratus", "enam ratus", "tujuh ratus", "delapan ratus", "sembilan ratus" };
    private static final String[] SCALE = { "", "ribu", "juta", "miliar", "triliun" };

    public String convertToTerbilang(long number) {
        if (number == 0) {
            return "nol";
        }

        StringBuilder result = new StringBuilder();

        // Handle large numbers by splitting into groups of three digits (thousands, millions, etc.)
        int scaleIndex = 0;

        while (number > 0) {
            int chunk = (int) (number % 1000);
            if (chunk > 0) {
                result.insert(0, convertChunk(chunk) + (scaleIndex > 0 ? " " + SCALE[scaleIndex] + " " : ""));
            }
            number /= 1000;
            scaleIndex++;
        }


        if (result.substring(0, Math.min(9, result.length())).trim().equalsIgnoreCase("satu ribu")) {
            return ("seribu " + result.substring(9, result.length()).trim()).trim();
        }
        return result.toString().trim();
    }

    private static String convertChunk(int number) {
        StringBuilder chunk = new StringBuilder();

        if (number >= 100) {
            chunk.append(HUNDREDS[number / 100]).append(" ");
            number %= 100;
        }

        if (number >= 11 && number <= 19) {
            chunk.append(TEENS[number - 11]).append(" "); // Correctly map numbers 11 to 19
        } else if (number >= 10) {
            chunk.append(TENS[number / 10]).append(" "); // For numbers 10, 20, 30, etc.
            number %= 10;  // Reduce number to ones place
        }

        if (number > 0 && number < 10) {
            chunk.append(ONES[number]); // Handle numbers 1 to 9
        }

        return chunk.toString().trim();
    }
}
