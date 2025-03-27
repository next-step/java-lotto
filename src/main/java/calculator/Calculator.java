package calculator;

import static util.ErrorMessage.*;

public final class Calculator {

    private Calculator() {
    }

    public static Calculator create() {
        return new Calculator();
    }

    public int run(final String input) {
        final Tokens tokens = Tokens.from(input);
        validateTokenStructure(tokens);
        return evaluate(tokens);
    }

    private void validateTokenStructure(final Tokens tokens) {
        if (!tokens.isOddSize()) {
            throw new IllegalArgumentException(INVALID_FORMAT);
        }
    }

    private int evaluate(final Tokens tokens) {
        int result = parseInt(tokens.get(0));

        for (int i = 1; i < tokens.size(); i += 2) {
            result = calculateNext(result, tokens.get(i), tokens.get(i + 1));
        }

        return result;
    }

    private int parseInt(final String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(INVALID_STRING);
        }
    }

    private int calculateNext(final int left, final String operatorSymbol, final String rightToken) {
        final int right = parseInt(rightToken);
        final Operator operator = Operator.from(operatorSymbol);
        return operator.apply(left, right);
    }
}
