package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        if (isBlank(input)) {
            return 0;
        }

        return sum(split(input));
    }

    private static boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }

    private static String[] split(String input) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (!matcher.find()) {
            return input.split(",|:");
        }

        return matcher.group(2).split(matcher.group(1));
    }

    private static int sum(String[] inputTokens) {
        int sum = 0;
        for (String token : inputTokens) {
            sum += Integer.parseInt(token);
        }

        return sum;
    }
}
