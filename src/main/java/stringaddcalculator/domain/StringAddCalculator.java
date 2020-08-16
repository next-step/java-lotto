package stringaddcalculator.domain;

import java.util.Arrays;

public class StringAddCalculator {

    private static final String DELIMITER = ":|,";

    public static int sum(String expression) {
        if (ValidationNumber.isBlank(expression)) {
            return 0;
        }

        String[] numbers = expressionSplit(expression);

        return Arrays.stream(numbers)
                .map(number -> toInt(number))
                .reduce(0, Integer::sum);
    }

    private static String[] expressionSplit(String expression) {
        return expression.split(DELIMITER);
    }

    private static int toInt(String number) {
        return Integer.parseInt(number);
    }

}
