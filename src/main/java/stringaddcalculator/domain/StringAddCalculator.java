package stringaddcalculator.domain;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DELIMITER = ":|,";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    public static final int ZERO_NUMBER = 0;
    private static final int CUSTOM_DELIMITER_CHERKER_ONE = 1;
    private static final int CUSTOM_DELIMITER_CHECKER_TWO = 2;
    private static Matcher expressionMatcher;

    public static int sum(String expression) {
        if (ValidationNumber.isBlank(expression)) {
            return ZERO_NUMBER;
        }

        String[] numbers = splitDelimiterCheck(expression);

        return Arrays.stream(numbers)
                .map(number -> toInt(number))
                .reduce(ZERO_NUMBER, Integer::sum);
    }

    private static String[] splitExpression(String expression) {
        return expression.split(DELIMITER);
    }

    private static int toInt(String number) {
        int result = Integer.parseInt(number);
        ValidationNumber.negativeQuantity(result);
        return result;
    }

    public static String[] splitDelimiterCheck(String expression) {
        expressionMatcher = Pattern.compile(CUSTOM_DELIMITER).matcher(expression);
        if (expressionMatcher.find()) {
            String customDelimiter = expressionMatcher.group(CUSTOM_DELIMITER_CHERKER_ONE);
            return expressionMatcher.group(CUSTOM_DELIMITER_CHECKER_TWO).split(customDelimiter);
        }
        return splitExpression(expression);
    }

}
