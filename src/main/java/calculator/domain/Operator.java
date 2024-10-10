package calculator.domain;

import java.util.List;

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

    public Operand add(final Operand left, final Operand right) {
        return new Operand(left.toInt() + right.toInt());
    }

    public Operand subtract(final Operand left, final Operand right) {
        return new Operand(left.toInt() - right.toInt());
    }

    public Operand multiply(final Operand left, final Operand right) {
        return new Operand(left.toInt() * right.toInt());
    }

    public Operand divide(final Operand left, final Operand right) {
        return new Operand(left.toInt() / right.toInt());
    }

    public Operand calculate(final Operand left, final Operand right) {
        return from(this.value).calculate(left, right);
    }
}
