package calculator.domain;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public enum CalculateOperater {
    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLICATION("*", (a, b) -> a * b),
    DIVISION("/", (a, b) -> {
        if (b == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return a / b;
    });

    private final String symbol;
    private final IntBinaryOperator operation;

    CalculateOperater(String symbol, IntBinaryOperator operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public static CalculateOperater fromSymbol(String symbol) {
        return Arrays.stream(values())
            .filter(op -> op.symbol.equals(symbol))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("사칙연산만 (+, -, *, /)가능합니다."));
    }

    public int apply(int a, int b) {
        return operation.applyAsInt(a, b);
    }
}
