package calculator.token.impl;

import calculator.token.Token;

public class NumberToken implements Token {

    private final int value;

    public NumberToken(String input) {
        this.value = Integer.parseInt(input);
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public boolean isOperator() {
        return false;
    }
}
