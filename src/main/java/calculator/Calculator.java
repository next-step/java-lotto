package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static final Pattern PERMIT_INPUT_REGEX = Pattern.compile("^[0-9+\\-*/ ]+$");
    public static final Pattern NUMBER_REGEX = Pattern.compile("^[0-9]+$");
    public static final Pattern SIGN_REGEX = Pattern.compile("^[+\\-*/]$");
    public static final String DEFAULT_DELIMITER = " ";

    public static int calculate(final String userInput) {
        isValidUserInput(userInput);
        final Tokens tokens = new Tokens(userInput.split(DEFAULT_DELIMITER));

        int result = Integer.parseInt(tokens.tokenAt(0));
        for (int i = 0; i < tokens.size(); i++) {
            if (tokens.tokenAt(i).equals("+")) {
                result = plus(result, Integer.parseInt(tokens.tokenAt(i + 1)));
            } else if (tokens.tokenAt(i).equals("-")) {
                result = minus(result, Integer.parseInt(tokens.tokenAt(i + 1)));
            } else if (tokens.tokenAt(i).equals("*")) {
                result = multiply(result, Integer.parseInt(tokens.tokenAt(i + 1)));
            } else if (tokens.tokenAt(i).equals("/")) {
                result = divide(result, Integer.parseInt(tokens.tokenAt(i + 1)));
            }
        }

        return result;
    }

    private static void isValidUserInput(final String userInput) {
        if (isEmpty(userInput)) {
            throw new IllegalArgumentException("계산할 정보가 없습니다.");
        }

        final Matcher matcher = PERMIT_INPUT_REGEX.matcher(userInput);
        if (!matcher.find()) {
            throw new IllegalArgumentException("허용되지 않는 문자가 입력되었습니다.");
        }
    }

    private static boolean isEmpty(final String userInput) {
        return userInput == null || userInput.isEmpty();
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

    private static int divide(final int a, final int b) {
        final double result = (double) a / b;

        if (!isInteger(result)) {
            throw new IllegalArgumentException("결과 값이 정수로 떨어지지 않습니다.");
        }

        return (int) result;
    }

    private static boolean isInteger(final double value) {
        return value == (int) value;
    }
}
