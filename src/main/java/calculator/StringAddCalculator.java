package calculator;

import java.util.Arrays;

public class StringAddCalculator {

    private static final int EMPTY_NUMBER = 0;

    public int exec(String input) {

        if (isNullOrEmpty(input)) {
            return EMPTY_NUMBER;
        }

        if (isStringSingle(input)) {
            return Integer.parseInt(input);
        }

        String[] strings = collectStringNumbers(input);
        return sumResult(strings);
    }

    private boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private boolean isStringSingle(String input) {
        return input.length() == 1;
    }

    private String[] collectStringNumbers(String input) {
        CalculatorParser calculatorParser = new CalculatorParser(input);
        return calculatorParser.split();
    }

    private int sumResult(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(this::parseInt)
                .sum();
    }

    private int parseInt(String str) {
        int number = Integer.parseInt(str);
        if (number < 0) {
            throw new IllegalArgumentException("input negative numbers");
        }
        return number;
    }
}
