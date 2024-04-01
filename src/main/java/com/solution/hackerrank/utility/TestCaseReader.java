package com.solution.hackerrank.utility;
/*
IntelliJ IDEA 2022.2.2 (Community Edition)
Build #IC-222.4167.29, built on September 13, 2022
Runtime version: 17.0.4+7-b469.53 amd64
@Author hakim a.k.a. Hakim Amarullah
Java Developer
Created on 3/29/2024 7:53 AM
@Last Modified 3/29/2024 7:53 AM
Version 1.0
*/

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class TestCaseReader {
    public static Scanner getInputScanner(String fileName) throws IOException {
        ClassLoader classLoader = TestCaseReader.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);
        if (inputStream == null) {
            throw new FileNotFoundException("File not found: " + fileName);
        }
        return new Scanner(inputStream);
    }
}
