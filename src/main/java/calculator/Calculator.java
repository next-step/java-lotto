package calculator;

import java.util.Objects;

public class Calculator {
    private static final String NUMBER_REGEX = "(-)?[0-9]+";
    private static final int ZERO = 0;

    public static int sum(String text) {
        if (isNullOrEmpty(text)) {
            return 0;
        }
        if (isNumber(text)) {
            return parseNumber(text);
        }
        String[] tokens = StringParser.parse(text);
        return sum(tokens);
    }

    private static int sum(String[] tokens) {
        int sum = 0;
        for (String token : tokens) {
            sum += parseNumber(token);
        }
        return sum;
    }

    private static boolean isNullOrEmpty(String text) {
        return Objects.isNull(text) || text.isEmpty();
    }

    private static boolean isNumber(String text) {
        return text.matches(NUMBER_REGEX);
    }

    private static int parseNumber(String text) {
        shouldBeNumber(text);
        int value = Integer.parseInt(text);
        shouldNotNegative(value);
        return value;
    }

    private static void shouldBeNumber(String text) {
        if (!isNumber(text)) {
            throw new IllegalArgumentException("숫자값을 입력해주세요.");
        }
    }

    private static void shouldNotNegative(int number) {
        if (number < ZERO) {
            throw new IllegalArgumentException("양수만 입력해주세요.");
        }
    }
}

