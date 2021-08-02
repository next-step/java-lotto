package calculator;

import java.util.Arrays;

public class Calculator {
    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final String OR = "|";
    private static final String CUSTOM_DELIMITER_OPEN_WRAPPER = "//";
    private static final String CUSTOM_DELIMITER_CLOSE_WRAPPER = "\\n";
    private static final int FIRST_INDEX = 0;

    public static int calculateAddition(String input) {
        int[] numbers = extractNumbers(input);
        return Arrays.stream(numbers)
                .reduce(0, Integer::sum);
    }

    static int[] extractNumbers(String input) {
        String delimiters = DEFAULT_DELIMITERS;
        if (hasCustomDelimiter(input)) {
            delimiters += OR + getCustomDelimiter(input);
            input = getCustomDelimiterInputRemoved(input);
        }

        String[] numbers = input.split(delimiters);
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static boolean hasCustomDelimiter(String input) {
        return input.indexOf(CUSTOM_DELIMITER_OPEN_WRAPPER) == FIRST_INDEX
                && input.contains(CUSTOM_DELIMITER_CLOSE_WRAPPER);
    }

    private static String getCustomDelimiter(String input) {
        int customDelimiterStartPosition = CUSTOM_DELIMITER_OPEN_WRAPPER.length();
        int customDelimiterEndPosition = input.indexOf(CUSTOM_DELIMITER_CLOSE_WRAPPER);
        return input.substring(customDelimiterStartPosition, customDelimiterEndPosition);
    }

    private static String getCustomDelimiterInputRemoved(String input) {
        int customDelimiterCloseWrapperEndPosition
                = input.indexOf(CUSTOM_DELIMITER_CLOSE_WRAPPER) + CUSTOM_DELIMITER_CLOSE_WRAPPER.length();
        return input.substring(customDelimiterCloseWrapperEndPosition);
    }
}
