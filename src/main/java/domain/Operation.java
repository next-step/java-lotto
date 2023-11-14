package domain;

import java.util.function.IntBinaryOperator;

public enum Operation {
    ADD("+", (a, b) -> a + b),
    SUBTRACT("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b),
    ;

    final String symbol;
    private final IntBinaryOperator operation;

    Operation(String symbol, IntBinaryOperator operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public int calculate(int operand1, int operand2) {
        return operation.applyAsInt(operand1, operand2);
    }

    public static Operation fromSymbol(String symbol) {
        for (Operation op : values()) {
            if (op.symbol.equals(symbol)) {
                return op;
            }
        }
        throw new IllegalArgumentException("유효하지 않은 사칙연산 기호입니다. symbol : " + symbol);
    }
}
