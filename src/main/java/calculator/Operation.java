package calculator;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum Operation {
    PLUS("+", (a, b) -> a + b),
    SUBTRACT("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b);

    private final String symbol;
    private final BinaryOperator<Integer> operation;

    Operation(String symbol, BinaryOperator<Integer> operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public static Operation from(String symbol) {
        return Arrays.stream(values())
                .filter(operation -> operation.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("연산자를 찾을 수 없습니다: " + symbol));
    }

    public int apply(int operand1, int operand2) {
        return operation.apply(operand1, operand2);
    }
}
