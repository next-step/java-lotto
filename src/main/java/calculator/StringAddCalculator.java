package calculator;

import utils.StringUtils;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final int ZERO = 0;
    private static final String COMMA_AND_COLON = ",|:";
    private static final Pattern REGEX_CUSTOM_DELIMITER = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String input) {
        if (StringUtils.isEmpty(input)) {
            return ZERO;
        }

        if (StringUtils.isNumeric(input)) {
            return Integer.parseInt(input);
        }

        Matcher matcher = REGEX_CUSTOM_DELIMITER.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String[] tokens = matcher.group(2).split(customDelimiter);
            return sum(tokens);
        }

        return sum(input.split(COMMA_AND_COLON));
    }

    private static int sum(String[] numberArray) {
        return Arrays.stream(numberArray)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}