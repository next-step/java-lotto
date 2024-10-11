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

    public int calculate(final int left, final int right) {
        return from(this.value).calculate(left, right);
    }
}
