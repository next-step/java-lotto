package com.jaenyeong.mission01.calculator;

import java.util.List;

import static com.jaenyeong.mission01.calculator.UI.inputExpression;
import static com.jaenyeong.mission01.calculator.UI.printResultNumber;

public class StringAddCalculator {
    public static final int ONLY_ONE = 1;
    public static final int FIRST = 0;

    public static void calculate() {
        final String inputExpression = inputExpression();

        final int resultSum = splitAndSum(inputExpression);

        printResultNumber(resultSum);
    }

    protected static int splitAndSum(final String inputExpression) {
        final List<Integer> inputNumbers = Parser.parseToNumbers(inputExpression);

        if (inputNumbers.size() == ONLY_ONE) {
            return inputNumbers.get(FIRST);
        }

        return getSum(inputNumbers);
    }

    protected static int getSum(final List<Integer> inputNumbers) {
        return inputNumbers.stream()
            .reduce(0, Integer::sum);
    }
}
