package calculator;

import java.util.Arrays;

public class StringAddCalculator {

    public static int splitAndSum(String expression) {
        return validate(expression);
    }

    private static Integer validate(String expression) {
        if (isEmptyOrNull(expression)) {
            return 0;
        }

        String[] numbers = split(expression);

        if (isOneLetter(numbers)) {
            return Integer.parseInt(numbers[0]);
        }

        return sum(numbers);
    }

    private static int sum(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private static String[] split(String expression) {
        return expression.split(",| ");
    }

    private static boolean isEmptyOrNull(String expression) {
        return expression == null || expression.isEmpty();
    }

    private static boolean isOneLetter(String[] expression) {
        return expression.length == 1;
    }
}
