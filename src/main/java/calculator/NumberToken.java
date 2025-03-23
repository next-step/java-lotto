package calculator;

import java.util.Objects;

public class NumberToken {
    private final int value;

    public NumberToken(int input) {
        this.value = input;
    }

    public NumberToken(String input) {
        this(Integer.parseInt(input));
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public NumberToken operate(NumberToken rightToken, OperatorToken operatorToken) {
        return new NumberToken(operatorToken.apply(this.value, rightToken.value));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        NumberToken that = (NumberToken) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
