package domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operation {
    ADDITION("+", Integer::sum),
    SUBTRACTION("-", (a, b) -> a - b),
    MULTIPLICATION("*", (a, b) -> a * b),
    DIVISION("/", (a, b) -> a / b);

    private final String symbol;
    private final BiFunction<Integer, Integer, Integer> operation;

    Operation(final String symbol, final BiFunction<Integer, Integer, Integer> operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public static Operation fromString(String input) {
        return Arrays.stream(Operation.values())
                .filter(operation -> operation.symbol.equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid operator: " + input));
    }
}
