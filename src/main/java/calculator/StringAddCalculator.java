package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String REGEX = ",| |:";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";

    public static int splitAndSum(String expression) {
        if (isEmptyOrNull(expression)) {
            return 0;
        }

        String[] tokens = split(expression);

        if (isOneLetter(tokens)) {
            return Integer.parseInt(tokens[0]);
        }

        return sum(tokens);
    }

    private static boolean isEmptyOrNull(String expression) {
        return expression == null || expression.isEmpty();
    }

    private static boolean isOneLetter(String[] expression) {
        return expression.length == 1;
    }

    private static String[] split(String expression) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(expression);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter + "|" + REGEX);
        }

        return expression.split(REGEX);
    }

    private static int sum(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
