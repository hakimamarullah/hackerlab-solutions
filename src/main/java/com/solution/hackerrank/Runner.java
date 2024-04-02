package com.solution.hackerrank;

import com.solution.hackerrank.problems.KimAndRefrigerators;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Runner {
    public static void main(String[] args) {
        try {
            new KimAndRefrigerators().answer();
        } catch (Exception e) {
            log.error("[SOLUTION ERROR]{}", e.getMessage(), e);
        }
    }
}