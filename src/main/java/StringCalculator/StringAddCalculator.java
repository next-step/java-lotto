package StringCalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }
        return add(split(input));
    }

    private static int add(String[] split) {
        int result = 0;
        for (String number : split) {
            result += parseInt(number);
        }
        return result;
    }

    private static String[] split(String input) {
        Matcher matcher = CUSTOM_PATTERN.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return input.split(",|:");
    }

    private static final int parseInt(String input) {
        int number = Integer.parseInt(input);
        if (number < 0) {
            throw new RuntimeException();
        }
        return number;
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }
}
