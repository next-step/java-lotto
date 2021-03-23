package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final int DEFAULT_RESULT = 0;
    private static final String DEFAULT_DELIMITER_REGEX = ",|:";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
    private static final String NEGATIVE_ERROR_MESSAGE = "음수는 처리할 수 없습니다.";
    private static final int DELIMITER_GROUP = 1;
    private static final int TEXT_GROUP = 2;

    private static final Pattern compiledCustomPattern = Pattern.compile(CUSTOM_DELIMITER_REGEX);

    public static int splitAndSum(final String text) {
        if (nullOrEmpty(text)) {
            return DEFAULT_RESULT;
        }

        final String[] tokens = tokens(text);

        if (containsNegative(tokens)) {
            throw new RuntimeException(NEGATIVE_ERROR_MESSAGE);
        }

        return sum(tokens);
    }

    private static boolean nullOrEmpty(final String text) {
        return text == null || text.isEmpty();
    }

    private static String[] tokens(final String text) {
        final Matcher matcher = compiledCustomPattern.matcher(text);
        if (matcher.find()) {
            final String customDelimiter = matcher.group(DELIMITER_GROUP);
            return matcher.group(TEXT_GROUP).split(customDelimiter);
        }

        return text.split(DEFAULT_DELIMITER_REGEX);
    }

    private static boolean containsNegative(final String[] tokens) {
        return Arrays.stream(tokens)
                .mapToInt(Integer::parseInt)
                .anyMatch(StringAddCalculator::negative);
    }

    private static boolean negative(final int n) {
        return n < 0;
    }

    private static int sum(final String[] tokens) {
        return Arrays.stream(tokens)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
