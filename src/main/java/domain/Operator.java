package domain;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public enum Operator {

    PLUS("+", Integer::sum),
    MINUS("-", (a, b) -> (a - b)),
    MULTIPLE("*", (a, b) -> (a * b)),
    DIVIDE("/", (a, b) -> (a / b)),
    ;
    private final String symbol;
    private final IntBinaryOperator operation;

    Operator(String symbol, IntBinaryOperator operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public static Operator toOperator(String input) {
        return Arrays.stream(values())
                .filter(it -> it.symbol.equals(input))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public int apply(int a, int b) {
        return operation.applyAsInt(a, b);
    }
}
