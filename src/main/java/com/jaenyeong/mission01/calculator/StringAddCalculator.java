package com.jaenyeong.mission01.calculator;

import java.util.List;

public class StringAddCalculator {

    public static void calculate() {
        Output.printTextExpression();

        final String inputExpression = Input.text();

        final int resultSum = splitAndSum(inputExpression);

        Output.printResultNumber(resultSum);
    }

    protected static int splitAndSum(final String inputExpression) {
        final List<Integer> inputNumbers = Parser.parseToNumbers(inputExpression);

        return getSum(inputNumbers);
    }

    protected static int getSum(final List<Integer> inputNumbers) {
        return inputNumbers.stream()
            .reduce(0, Integer::sum);
    }
}
