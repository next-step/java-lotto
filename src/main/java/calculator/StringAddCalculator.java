package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    private static final String DEFAULT_DELIMITER_REGEX = ",|:";

    private static final int DELIMITER_GROUP = 1;

    private static final int DELIMITED_NUMBERS_GROUP = 2;

    private StringAddCalculator() {}

    public static int add(final String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            return sum(split(matcher.group(DELIMITED_NUMBERS_GROUP),
                    matcher.group(DELIMITER_GROUP)));
        }

        return sum(split(input, DEFAULT_DELIMITER_REGEX));
    }

    private static int sum(String[] tokens) {
        return Arrays.stream(tokens)
                .map(Number::valueOf)
                .reduce(0, Integer::sum);
    }

    private static String[] split(final String delimitedNumbers, final String delimiter) {
        return delimitedNumbers.split(delimiter);
    }
}
