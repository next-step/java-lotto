package calculator;

import calculator.token.Tokens;

import static common.message.ErrorMessage.*;

public final class Calculator {

    private Calculator() {
    }

    public static Calculator create() {
        return new Calculator();
    }

    public int run(final String input) {

        Tokens tokens = Tokens.from(input);
        validateTokenStructure(tokens);

        return tokens.evaluate();
    }

    private void validateTokenStructure(final Tokens tokens) {
        if (!tokens.isOddSize()) {
            throw new IllegalArgumentException(INVALID_FORMAT);
        }
    }
}
