package com.cheolhyeonpark.calculator;

import com.cheolhyeonpark.calculator.domain.ExpressionGenerator;

public class StringAddCalculator {

    public static int splitAndSum(String input) {

        if (isEmpty(input)) {
            return 0;
        }

        return new ExpressionGenerator().generate(input).getSum();
    }

    private static boolean isEmpty(String input) {
        return input == null || input.length() < 1;
    }
}
