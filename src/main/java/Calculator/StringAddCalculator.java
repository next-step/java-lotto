package Calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String REGEX_DELIMITER_DEFAULT = "[,:]";
    private static final String REGEX_DELIMITER_PATTERN = "//(.)\\n(.*)";

    private static final int ZERO = 0;
    private static final String EMPTY_VALUE = "";

    private static final int MATCHER_DELIMITER_GROUP = 1;
    private static final int MATCHER_EXPRESSION_GROUP = 2;

    private static final String MESSAGE_INVALID_INPUT = "입력값은 0이상의 숫자여야 합니다.";
    private static final String MESSAGE_UTILITY_CLASS = "Utility class";

    private StringAddCalculator() {
        throw new IllegalStateException(MESSAGE_UTILITY_CLASS);
    }

    public static int splitAndSum(String input) {
        if (isValidInput(input)) {
            return ZERO;
        }

        return sum(split(input));
    }

    private static boolean isValidInput(String input) {
        return input == null || input.equals(EMPTY_VALUE);
    }

    private static String[] split(String input) {
        Matcher matcher = Pattern.compile(REGEX_DELIMITER_PATTERN).matcher(input);

        if (matcher.find()) {
            return split(matcher.group(MATCHER_DELIMITER_GROUP), matcher.group(MATCHER_EXPRESSION_GROUP));
        }
        return split(REGEX_DELIMITER_DEFAULT, input);
    }

    private static String[] split(String delimiter, String expression) {
        return expression.split(delimiter);
    }

    private static int sum(String[] list) {
        return Arrays.stream(list)
                .mapToInt(StringAddCalculator::parseInt)
                .sum();
    }

    private static int parseInt(String value) {
        int num = Integer.parseInt(value);
        if (num < ZERO) {
            throw new IllegalArgumentException(MESSAGE_INVALID_INPUT);
        }
        return num;
    }
}
