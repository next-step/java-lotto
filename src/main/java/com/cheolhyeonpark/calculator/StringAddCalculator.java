package com.cheolhyeonpark.calculator;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        if (input == null || input.length() < 1) {
            return 0;
        }
        return Integer.parseInt(input);
    }
}
