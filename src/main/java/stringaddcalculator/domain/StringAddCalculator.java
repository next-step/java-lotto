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
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER);

    public static int sum(String expression) {
        if (ValidationNumber.isBlank(expression)) {
            return ZERO_NUMBER;
        }

        String[] numbers = splitDelimiterCheck(expression);

        return Arrays.stream(numbers)
                .map(number -> new Number(number).getNumber())
                .reduce(ZERO_NUMBER, Integer::sum);
    }

    private static String[] splitExpression(String expression) {
        return expression.split(DELIMITER);
    }

    public static String[] splitDelimiterCheck(String expression) {
        Matcher delimiterMatcher = CUSTOM_DELIMITER_PATTERN.matcher(expression);
        if (delimiterMatcher.find()) {
            String customDelimiter = delimiterMatcher.group(CUSTOM_DELIMITER_CHERKER_ONE);
            return delimiterMatcher.group(CUSTOM_DELIMITER_CHECKER_TWO).split(customDelimiter);
        }
        return splitExpression(expression);
    }

}
