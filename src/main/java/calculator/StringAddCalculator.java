package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String REGEX = ",| |:";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";

    public static int splitAndSum(Expression expression) {
        if (expression.isEmptyOrNull()) {
            return 0;
        }

        if (expression.isOneLetter()) {
            return Integer.parseInt(expression.toString());
        }

        expression.isNegative();
        return sum(split(expression.toString()));
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
