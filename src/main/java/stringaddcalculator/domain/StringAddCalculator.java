package stringaddcalculator.domain;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DELIMITER = ":|,";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";

    public static int sum(String expression) {
        if (ValidationNumber.isBlank(expression)) {
            return 0;
        }

        String[] numbers = splitDelimiterCheck(expression);

        return Arrays.stream(numbers)
                .map(number -> toInt(number))
                .reduce(0, Integer::sum);
    }

    private static String[] expressionSplit(String expression) {
        return expression.split(DELIMITER);
    }

    private static int toInt(String number) {
        int result = Integer.parseInt(number);
        ValidationNumber.negativeQuantity(result);
        return result;
    }

    public static String[] splitDelimiterCheck(String expression) {
        Matcher expressionMatcher = Pattern.compile(CUSTOM_DELIMITER).matcher(expression);
        if (expressionMatcher.find()) {
            String customDelimiter = expressionMatcher.group(1);
            return expressionMatcher.group(2).split(customDelimiter);
        }
        return expressionSplit(expression);
    }

}
