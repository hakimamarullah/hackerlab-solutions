package com.solution.hackerrank.aeon;
/*
@Author hakim a.k.a. Hakim Amarullah
Java Developer
Created on 5/30/2024 2:57 PM
@Last Modified 5/30/2024 2:57 PM
Version 1.0
*/

import java.util.Deque;
import java.util.LinkedList;

public class Problem4 {


    /**
     * Assumption: String S only contains "(", "{", "[", "]", "}" and/or ")" without any whitespace.
     *
     * @param s a string
     * @return boolean
     */
    public boolean solution(String s) {
        char[] chars = s.toCharArray();
        Deque<Character> stack = new LinkedList<>();


        for (char currentChar : chars) {
            if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
                stack.push(currentChar);
            } else if(stack.isEmpty()){
                return false;
            } else {
                char charInStack = stack.pop();
                if(!isValidPair(charInStack, currentChar)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValidPair(char open, char close) {
        if (open == '[' && close == ']') {
            return true;
        }

        if (open == '{' && close == '}') {
            return true;
        }

        return open == '(' && close == ')';
    }
}
