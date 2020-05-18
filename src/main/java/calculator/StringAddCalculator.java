package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final int MIN_NUMBER = 0;
    private static final Pattern INPUT_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String input) {
        if (isBlank(input)) {
            return 0;
        }

        return sum(splitInputValue(input));
    }

    private static boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }

    private static String[] splitInputValue(String input) {
        Matcher matcher = INPUT_DELIMITER_PATTERN.matcher(input);
        if (!matcher.find()) {
            return input.split(",|:");
        }

        return matcher.group(2).split(matcher.group(1));
    }

    private static int sum(String[] inputTokens) {
        int sum = 0;
        for (String token : inputTokens) {
            int number = Integer.parseInt(token);
            validateNumber(number);

            sum += number;
        }

        return sum;
    }

    private static void validateNumber(int number) {
        if (number < MIN_NUMBER) {
            throw new RuntimeException();
        }
    }
}
