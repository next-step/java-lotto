package carculator.domain.token;

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
        if (value <= 0) {
            throw new IllegalArgumentException("Value cannot be negative: " + value);
        }
    }

    public Integer plus(Operand b) {
        return this.value + b.value;
    }

    public Integer minus(Operand b) {
        return this.value - b.value;
    }

    public Integer multiply(Operand b) {
        return this.value * b.value;
    }

    public Integer divide(Operand b) {
        return this.value / b.value;
    }
}
