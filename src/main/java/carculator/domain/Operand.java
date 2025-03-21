package carculator.domain;

public class Operand {
    Integer value;

    public Operand(Integer value) {
        if (value == null) {
            throw new NullPointerException("value is null");
        }

        if (value < 0) {
            throw new IllegalArgumentException("Value cannot be negative");
        }

        this.value = value;
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
