package calculator;

import java.util.Arrays;
import java.util.function.ToIntFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private final static int DELIMITER_GROUP_ID = 1;
    private final static int EXPRESSION_GROUP_ID = 2;
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";
    private static final Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_REGEX);

    private StringAddCalculator() {
    }

    public static int splitAndSum(String expression) {
        if (isNullOrEmpty(expression)) {
            return 0;
        }
        return getSum(expression);
    }

    private static int getSum(String expression) {
        Matcher m = pattern.matcher(expression);
        if (m.find()) {
            return getSum(getTokens(m.group(EXPRESSION_GROUP_ID), m.group(DELIMITER_GROUP_ID)));
        }
        return getSum(getTokens(expression, DEFAULT_DELIMITER_REGEX));
    }

    private static String[] getTokens(String expression, String delimiter) {
        return expression.split(delimiter);
    }

    private static int getSum(String[] numberStrings) {
        return Arrays.stream(numberStrings)
                .mapToInt(getNumberFromString())
                .sum();
    }

    private static ToIntFunction<String> getNumberFromString() {
        return string -> {
            int number = Integer.parseInt(string);
            validateUnsignedNumber(number);
            return number;
        };
    }

    private static void validateUnsignedNumber(int number) {
        if (number < 0) {
            throw new RuntimeException("0이상의 숫자가 입력되어야 합니다.");
        }
    }

    private static boolean isNullOrEmpty(String expression) {
        return expression == null || expression.isEmpty();
    }
}
