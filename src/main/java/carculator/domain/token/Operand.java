package carculator.domain.token;

import java.util.Objects;

public class Operand implements Token {

    private final Integer value;

    public Operand(Integer value) {
        validateNotNull(value);
        validatePositive(value);

        this.value = value;
    }

    private static void validateNotNull(Integer value) {
        if (value == null) {
            throw new NullPointerException("value is null");
        }
    }

    private static void validatePositive(Integer value) {
        if (value < 0) {
            throw new IllegalArgumentException("Value cannot be negative: " + value);
        }
    }

    protected Integer plus(Operand that) {
        return this.value + that.value;
    }

    protected Integer minus(Operand that) {
        return this.value - that.value;
    }

    protected Integer multiply(Operand that) {
        return this.value * that.value;
    }

    protected Integer divide(Operand that) {
        return this.value / that.value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Operand operand = (Operand) o;
        return Objects.equals(value, operand.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
