package com.jaenyeong.mission01.calculator;

import java.util.List;

import static com.jaenyeong.mission01.calculator.UI.inputExpression;
import static com.jaenyeong.mission01.calculator.UI.printResultNumber;

public class StringAddCalculator {

    public static void calculate() {
        final String inputExpression = inputExpression();

        final int resultSum = splitAndSum(inputExpression);

        printResultNumber(resultSum);
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
