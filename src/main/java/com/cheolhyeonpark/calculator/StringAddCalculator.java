package com.cheolhyeonpark.calculator;

import java.util.Arrays;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        if (input == null || input.length() < 1) {
            return 0;
        }
        if (input.contains(",")) {
            String[] numbers = input.split(",");
            return Arrays.stream(numbers).mapToInt(Integer::parseInt).sum();
        }
        return Integer.parseInt(input);
    }
}
