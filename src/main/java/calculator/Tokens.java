package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;

import static calculator.Calculator.NUMBER_REGEX;
import static calculator.Calculator.SIGN_REGEX;

public class Tokens {
    private final List<String> tokens;

    public Tokens(final String[] tokens) {
        validateExpression(tokens);
        this.tokens = Arrays.asList(tokens);
    }

    private static void validateExpression(final String[] tokens) {
        validateTokenCountIsOdd(tokens);
        validateTokensByPosition(tokens);
    }

    private static void validateTokenCountIsOdd(final String[] tokens) {
        if (tokens.length % 2 == 0) {
            throw new IllegalArgumentException("수식에 오류가 있습니다.");
        }
    }

    private static void validateTokensByPosition(final String[] tokens) {
        for (int i = 0; i < tokens.length; i++) {
            validateToken(tokens[i], i);
        }
    }

    private static void validateToken(final String token, final int index) {
        if (isEven(index)) {
            validateNumberToken(token);
        }

        if (!isEven(index)) {
            validateSignToken(token);
        }
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    private static void validateSignToken(final String token) {
        final Matcher matcher = SIGN_REGEX.matcher(token);
        if (!matcher.find()) {
            throw new IllegalArgumentException("수식에 오류가 있습니다.");
        }
    }

    private static void validateNumberToken(final String token) {
        final Matcher matcher = NUMBER_REGEX.matcher(token);
        if (!matcher.find()) {
            throw new IllegalArgumentException("수식에 오류가 있습니다.");
        }
    }

    public int size() {
        return tokens.size();
    }

    public String tokenAt(final int index) {
        return tokens.get(index);
    }
}
