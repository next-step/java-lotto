package calculator.domain;

import java.util.List;
import java.util.Objects;

import static calculator.enumeration.OperationSymbol.*;

public class Operator {
    public static final List<String> ARITHMETIC_SYMBOLS = List.of("+", "-", "*", "/");

    private final String value;

    public Operator(final String value) {
        if (!ARITHMETIC_SYMBOLS.contains(value)) {
            throw new IllegalArgumentException("Invalid operator: " + value);
        }
        this.value = value;
    }

    public Operand calculate(final Operand left, final Operand right) {
        return from(this.value).calculate(left, right);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Operator operator = (Operator) o;
        return Objects.equals(value, operator.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return "Operator{" +
                "value='" + value + '\'' +
                '}';
    }
}
