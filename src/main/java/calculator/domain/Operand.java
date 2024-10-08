package calculator.domain;

import calculator.dto.CalculationResult;

import java.util.Objects;

public class Operand {
    private final String value;

    public Operand(final String value) {
        this.value = value;
    }

    public Operand(final int value) {
        this.value = String.valueOf(value);
    }

    public Integer toInt() {
        return Integer.parseInt(value);
    }

    public Operand add(final Operand right) {
        return new Operand(this.toInt() + right.toInt());
    }

    public Operand subtract(final Operand right) {
        return new Operand(this.toInt() - right.toInt());
    }

    public Operand multiply(final Operand right) {
        return new Operand(this.toInt() * right.toInt());
    }

    public Operand divide(final Operand right) {
        return new Operand(this.toInt() / right.toInt());
    }

    public CalculationResult toCalculationResult() {
        return new CalculationResult(this.value);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Operand operand = (Operand) o;
        return Objects.equals(value, operand.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return "Operand{" +
                "value='" + value + '\'' +
                '}';
    }
}
