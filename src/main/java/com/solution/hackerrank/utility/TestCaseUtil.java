package com.solution.hackerrank.utility;
/*
@Author hakim a.k.a. Hakim Amarullah
Java Developer
Created on 3/29/2024 7:53 AM
@Last Modified 3/29/2024 7:53 AM
Version 1.0
*/

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class TestCaseUtil {

    private TestCaseUtil() {};
    public static Scanner getInputScanner(String fileName) throws IOException {
        ClassLoader classLoader = TestCaseUtil.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);
        if (inputStream == null) {
            throw new FileNotFoundException("File not found: " + fileName);
        }
        return new Scanner(inputStream);
    }

    public static void compareResult(String className) throws IOException {
        String inputFile = resolveFile("result/".concat(className).concat(".txt"));
        String output = resolveFile("output/".concat(className).concat(".txt"));
        String comparation = resolveFile("comparation/".concat(className).concat(".txt"));
        try (BufferedReader reader1 = new BufferedReader(new FileReader(inputFile));
             BufferedReader reader2 = new BufferedReader(new FileReader(output));
             BufferedWriter writer = new BufferedWriter(new FileWriter(comparation))){


            int lineNumber = 1;
            List<String> result1 = reader1.lines().toList();
            List<String> result2 = reader2.lines().toList();


        }
    }

    private static String resolveFile(String relativePath) {
        Path path = Paths.get("src", "main", "resources");
        return path.resolve(relativePath).toString();
    }

    public static BufferedWriter getOutputWriter(String className) throws IOException {
        Path outputPath = Paths.get("src", "main", "resources", "result", className + ".txt");
        return new BufferedWriter(new FileWriter(outputPath.toString()));
    }


}
