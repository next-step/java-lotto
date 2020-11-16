package step01;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static String TOKENS = ",|:";
    private static String PATTERN = "//(.)\n(.*)";
    private static String NEGATIVE_EXCEPTION_MESSAGE = "음수는 계산할 수 없습니다.";

    private static boolean isBlank(String input) {
        return input == null || input.trim() == "";
    }

    private static boolean isANumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    private static Matcher matchPattern(String input) {
        return Pattern.compile(PATTERN).matcher(input);
    }

    private static String[] tokenize(String input, String delimiter) {
        return input.split(delimiter);
    }

    private static String[] tokenize(String input, Matcher matcher) {
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return tokenize(matcher.group(2), customDelimiter);
        }
        return tokenize(input, TOKENS);
    }

    private static void validateNotNegative(int input) {
        if (input < 0) {
            throw new RuntimeException(NEGATIVE_EXCEPTION_MESSAGE);
        }
    }

    public static int calculate(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .reduce(0, (a, b) -> {
                    validateNotNegative(a);
                    return a + b;
                });
    }

    public static int splitAndSum(String input) {
        if (isBlank(input))
            return 0;

        if (isANumber(input))
            return Integer.parseInt(input);

        String[] numbers = tokenize(input, matchPattern(input));

        return calculate(numbers);

    }
}
