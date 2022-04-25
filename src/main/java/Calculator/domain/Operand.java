package Calculator.domain;

import java.util.Objects;

public class Operand extends MathematicalExpression {
    private final int value;

    public Operand(String value) {
        this(Integer.parseInt(value));
    }

    public Operand(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operand operand = (Operand) o;
        return value == operand.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
