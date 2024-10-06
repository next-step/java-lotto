package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static final Pattern PERMIT_INPUT_REGEX = Pattern.compile("^[0-9+\\-*/ ]+$");
    public static final Pattern NUMBER_REGEX = Pattern.compile("^[0-9]+$");
    public static final Pattern SIGN_REGEX = Pattern.compile("^[+\\-*/]$");
    public static final String DEFAULT_DELIMITER = " ";

    public static int calculate(final String userInput) {
        if (userInput == null || userInput.isEmpty()) {
            throw new IllegalArgumentException("계산할 정보가 없습니다.");
        }

        final Matcher matcher = PERMIT_INPUT_REGEX.matcher(userInput);
        if (!matcher.find()) {
            throw new IllegalArgumentException("허용되지 않는 문자가 입력되었습니다.");
        }

        final String[] split = userInput.split(DEFAULT_DELIMITER);
        if (split.length % 2 == 0) {
            throw new IllegalArgumentException("수식에 오류가 있습니다.");
        }

        for (int i = 0; i < split.length; i++) {
            // 짝수는 숫자여야 함.
            if (i % 2 == 0) {
                final Matcher numberMatcher = NUMBER_REGEX.matcher(split[i]);
                if (!numberMatcher.find()) {
                    throw new IllegalArgumentException("수식에 오류가 있습니다.");
                }
            }

            // 홀수는 기호여야 함.
            if (i % 2 == 1) {
                final Matcher signMatcher = SIGN_REGEX.matcher(split[i]);
                if (!signMatcher.find()) {
                    throw new IllegalArgumentException("수식에 오류가 있습니다.");
                }
            }
        }

        int result = Integer.parseInt(split[0]);
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("+")) {
                result = plus(result, Integer.parseInt(split[i + 1]));
            } else if (split[i].equals("-")) {
                result = minus(result, Integer.parseInt(split[i + 1]));
            } else if (split[i].equals("*")) {
                result = multiply(result, Integer.parseInt(split[i + 1]));
            }
        }

        return result;
    }

    private static int plus(final int a, final int b) {
        return a + b;
    }

    private static int minus(final int a, final int b) {
        return a - b;
    }

    private static int multiply(final int a, final int b) {
        return a * b;
    }
}
