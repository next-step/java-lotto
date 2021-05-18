package string_calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DECIDED_DELIMITER = ",|:";
    private static final int DEFAULT_NUMBER = 0;
    private static final int FIRST_MATCH = 1;
    private static final int SECOND_MATCH = 2;

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return DEFAULT_NUMBER;
        }
        return add(split(input));
    }

    private static int add(String[] split) {
        int result = DEFAULT_NUMBER;
        for (String number : split) {
            result += parseInt(number);
        }
        return result;
    }

    private static String[] split(String input) {
        Matcher matcher = CUSTOM_PATTERN.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(FIRST_MATCH);
            return matcher.group(SECOND_MATCH).split(customDelimiter);
        }
        return input.split(DECIDED_DELIMITER);
    }

    private static final int parseInt(String input) {
        int number = Integer.parseInt(input);
        if (number < DEFAULT_NUMBER) {
            throw new RuntimeException();
        }
        return number;
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }
}
