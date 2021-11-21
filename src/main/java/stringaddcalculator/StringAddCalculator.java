package stringaddcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringAddCalculator {

    private static final Number ZERO = Number.init();
    private static final Pattern COMPILE = Pattern.compile(",|:");

    private StringAddCalculator() {
    }

    public static Number splitAndSum(String expression) {
        if (expression == null || expression.isEmpty()) {
            return ZERO;
        }

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(expression);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] numbers = m.group(2).split(customDelimiter);
            validatePositiveOrThrow(numbers);
            return new Number(sum(numbers));
        }

        String[] numbers = COMPILE.split(expression);
        validatePositiveOrThrow(numbers);
        return new Number(sum(numbers));
    }

    private static void validatePositiveOrThrow(String[] numbers) {
        boolean isExistNegative = Arrays.stream(numbers)
                                        .map(Integer::parseInt)
                                        .anyMatch(number -> number < 0);
        if (isExistNegative) {
            throw new RuntimeException("expression's values must be positive");
        }
    }

    private static int sum(String[] numbers) {
        return Arrays.stream(numbers)
                     .map(Integer::parseInt)
                     .mapToInt(Integer::intValue)
                     .sum();
    }
}
