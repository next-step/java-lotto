package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\\\\n(.*)");
    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";
    private static final int NUMBERS_JOINED_BY_DELIMITER_GROUP = 2;
    private static final int CUSTOM_DELIMITER_GROUP = 1;
    private static final int RESULT_FOR_EMPTY_INPUT = 0;
    private static final int MINIMUM_NON_NEGATIVE_INTEGER = 0;
    private static final String INVALID_INPUT_EXCEPTION_MESSAGE_FORMAT = "유효하지 않은 입력입니다. input: %s";
    private static final String NEGATIVE_INTEGER_EXCEPTION_MESSAGE_FORMAT = "입력 값 중, 음수가 존재합니다. numberString: %s";

    public int calculate(String input) {
        try {
            return isEmpty(input) ? RESULT_FOR_EMPTY_INPUT : calculate(parse(input));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(String.format(INVALID_INPUT_EXCEPTION_MESSAGE_FORMAT, input));
        }
    }

    private boolean isEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private int calculate(String[] stringsParsedByDelimiter) {
        return Arrays.stream(stringsParsedByDelimiter)
                .mapToInt(this::convertStringToNonNegativeInteger)
                .sum();
    }

    private int convertStringToNonNegativeInteger(String numberString) {
        int number = Integer.parseInt(numberString);
        validateNonNegativeInteger(number);
        return number;
    }

    private void validateNonNegativeInteger(int number) {
        if (number < MINIMUM_NON_NEGATIVE_INTEGER) {
            throw new IllegalArgumentException(String.format(NEGATIVE_INTEGER_EXCEPTION_MESSAGE_FORMAT, number));
        }
    }

    private String[] parse(String input) {
        Matcher customDelimiterMatcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (customDelimiterMatcher.find()) {
            return parseWithCustomDelimiter(customDelimiterMatcher);
        }
        return input.split(DEFAULT_DELIMITER_REGEX);
    }

    private String[] parseWithCustomDelimiter(Matcher customDelimiterMatcher) {
        return getNumbersJoinedByDelimiter(customDelimiterMatcher)
                    .split(getCustomDelimiter(customDelimiterMatcher));
    }

    private String getNumbersJoinedByDelimiter(Matcher customDelimiterMatcher) {
        return customDelimiterMatcher.group(NUMBERS_JOINED_BY_DELIMITER_GROUP);
    }

    private String getCustomDelimiter(Matcher customDelimiterMatcher) {
        return Pattern.quote(customDelimiterMatcher.group(CUSTOM_DELIMITER_GROUP));
    }

}
