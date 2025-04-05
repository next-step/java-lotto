package calculator.token.impl;

import calculator.Operator;
import calculator.token.Token;

public class OperatorToken implements Token {

    private final Operator value;

    public OperatorToken(String input) {
        this.value = Operator.from(input);
    }

    public int apply(int left, NumberToken numberToken) {
        return this.value.apply(left, numberToken.getValue());
    }

    @Override
    public boolean isOperator() {
        return true;
    }
}
