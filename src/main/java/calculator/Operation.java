package calculator;

import java.util.function.IntBinaryOperator;

public enum Operation {
    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLE("*", (a, b) -> a * b),
    DIVISION("/", (a, b) -> {
        if (b == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return a / b;
    });

    private final String symbol;
    private final IntBinaryOperator operation;

    Operation(String symbol, IntBinaryOperator operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public static int calculate(final String operator, final int num1, final int num2) {
        for (Operation operation : Operation.values()) {
            if (operation.symbol.equals(operator)) {
                return operation.operation.applyAsInt(num1, num2);
            }
        }
        throw new IllegalArgumentException("올바른 사칙연산자가 아닙니다.");
    }
}
