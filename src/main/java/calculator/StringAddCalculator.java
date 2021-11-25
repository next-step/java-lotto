package calculator;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";
    private static final int GROUP_INDEX_DELIMITER = 1;
    private static final int GROUP_INDEX_SPLITTABLE_INPUT = 2;

    public static int splitAndSum(final String input) {
        if (isInvalidInput(input)) {
            return 0;
        }

        final String[] splitNumbers = getSplitNumbers(input);
        return sum(splitNumbers);
    }

    private static boolean isInvalidInput(final String input) {
        if (Objects.isNull(input)) {
            return true;
        }

        return input.isEmpty();
    }

    private static String[] getSplitNumbers(final String input) {
        String delimiterRegex = DEFAULT_DELIMITER_REGEX;
        String splittableInput = input;

        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (matcher.find()) {
            final String customDelimiter = matcher.group(GROUP_INDEX_DELIMITER);
            delimiterRegex = String.format("%s|%s", DEFAULT_DELIMITER_REGEX, customDelimiter);
            splittableInput = matcher.group(GROUP_INDEX_SPLITTABLE_INPUT);
        }

        return splittableInput.split(delimiterRegex);
    }

    private static int sum(final String[] splitNumbers) {
        return Arrays.stream(splitNumbers)
            .mapToInt(Integer::parseUnsignedInt)
            .reduce(0, Integer::sum);
    }
}
