package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";
    private static final String ZERO_OR_POSITIVE_NUMBER_PATTERN = "^[0-9]+$";
    private static final String OR = "|";
    private static final int CUSTOM_DELIMITER_GROUP_INDEX = 1;
    private static final int INPUT_REMOVED_CUSTOMER_DELIMITER_GROUP_INDEX = 2;
    private static final int DEFAULT_SUM_VALUE = 0;
    private static final int INITIAL_SUM_VALUE = 0;

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return DEFAULT_SUM_VALUE;
        }

        int[] numbers = extractNumbers(input);
        return Arrays.stream(numbers)
                .reduce(INITIAL_SUM_VALUE, Integer::sum);
    }

    private static boolean isNullOrEmpty(String input) {
        if (input == null || input.isEmpty()) {
            return true;
        }
        return false;
    }

    private static int[] extractNumbers(String input) {
        String delimiters = getDelimitersOf(input);
        String numbersWithDelimiters = getInputRemovedCustomDelimiter(input);

        String[] numbers = numbersWithDelimiters.split(delimiters);
        validateZeroOrPositiveNumber(numbers);

        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static String getDelimitersOf(String input) {
        String delimiters = DEFAULT_DELIMITERS;
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(CUSTOM_DELIMITER_GROUP_INDEX);
            delimiters += OR + customDelimiter;
        }
        return delimiters;
    }

    private static String getInputRemovedCustomDelimiter(String input) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(input);
        if (matcher.find()) {
            return matcher.group(INPUT_REMOVED_CUSTOMER_DELIMITER_GROUP_INDEX);
        }
        return input;
    }

    private static void validateZeroOrPositiveNumber(String[] numbers) {
        for (String number : numbers) {
            validateZeroOrPositiveNumber(number);
        }
    }

    private static void validateZeroOrPositiveNumber(String number) {
        if (!number.matches(ZERO_OR_POSITIVE_NUMBER_PATTERN)) {
            throw new IllegalArgumentException("숫자는 0 또는 양수이어야 합니다.");
        }
    }
}
