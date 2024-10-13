package calculator;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public enum Operation {
    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    MULTIPLY("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);

    private final String symbol;
    private final IntBinaryOperator operator;

    Operation(String symbol, IntBinaryOperator operator) {
        this.symbol = symbol;
        this.operator = operator;
    }

    public static Operation getOperation(String symbol) {
        return Arrays.stream(values())
                .filter((operation -> operation.symbol.equals(symbol)))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 연산자입니다."));
    }

    public int apply(int left, int right) {
        return operator.applyAsInt(left, right);
    }
}