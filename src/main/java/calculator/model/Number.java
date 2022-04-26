package calculator.model;

import calculator.util.IntParser;
import calculator.util.Operator;

import java.util.Objects;

public class Number {
    private final int value;

    public Number() {
        this(0);
    }

    public Number(String value) {
        this(IntParser.parse(value));
    }

    public Number(int value) {
        this.checkNegative(value);
        this.value = value;
    }

    public Number calculate(Symbol symbol, Number right) {
        int result = Operator.operator(symbol).apply(this.value, right.value);
        return new Number(result);
    }

    private void checkNegative(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("음수는 허용하지 않습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
