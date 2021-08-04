package calculator;

import java.util.Arrays;

public class StringAddCalculator {

    private static final int EMPTY_NUMBER = 0;

    private StringAddCalculator() {
    }

    public static int exec(String input) {

        if (isEmptyOrNull(input)) {
            return EMPTY_NUMBER;
        }

        if (isStringSingle(input)) {
            return Integer.parseInt(input);
        }

        String[] strings = collectStringNumbers(input);

        return sumResult(strings);
    }

    private static boolean isEmptyOrNull(String s) {
        return s == null || s.isEmpty();
    }

    private static boolean isStringSingle(String s) {
        return s.length() == 1;
    }

    private static String[] collectStringNumbers(String s) {
        CalculatorParser calculatorParser = new CalculatorParser(s);
        return calculatorParser.split();
    }

    private static int sumResult(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(StringAddCalculator::parseInt)
                .sum();
    }

    private static int parseInt(String str) {
        int number = Integer.parseInt(str);
        if (number < 0) {
            throw new RuntimeException("input negative numbers");
        }
        return number;
    }
}
