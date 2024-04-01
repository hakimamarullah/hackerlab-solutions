package com.solution.hackerrank;

import com.solution.hackerrank.problems.DequeMaxUniqueNumberSubArray;
import com.solution.hackerrank.problems.TravellingSalesPerson;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.logging.Logger;

@Slf4j
public class Runner {
    public static void main(String[] args) {
        try {
            new TravellingSalesPerson().answer();
        } catch (Exception e) {
            log.error("[SOLUTION ERROR]{}", e.getMessage(), e);
        }
    }
}