package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String REGEX = ",| |:";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
    private static final String NEGATIVE_OPERATOR = "-";

    public static int splitAndSum(String expression) {
        if (isEmptyOrNull(expression)) {
            return 0;
        }

        if (isOneLetter(expression)) {
            return Integer.parseInt(expression);
        }

        isNegative(expression);
        return sum(split(expression));
    }

    private static boolean isEmptyOrNull(String expression) {
        return expression == null || expression.isEmpty();
    }

    private static boolean isOneLetter(String expression) {
        return expression.length() == 1;
    }

    private static void isNegative(String expression) {
        if (expression.contains(NEGATIVE_OPERATOR)) {
            throw new RuntimeException("음수가 포함되어 있는지 확인해주세요.");
        }
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
