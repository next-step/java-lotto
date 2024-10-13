package calculator;

import java.util.function.IntBinaryOperator;

public enum OperationType {
    ADD("+", Integer::sum),
    SUBTRACT("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> {
        if (b == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다");
        }
        return a / b;
    }),
    UNKNOWN("UNKNOWN", (a, b) -> {
        throw new IllegalArgumentException("유효하지 않은 연산자가 입력되었습니다");
    });

    private final String symbol;
    private final IntBinaryOperator operator;

    OperationType(String symbol, IntBinaryOperator operator) {
        this.symbol = symbol;
        this.operator = operator;
    }

    public static OperationType fromSymbol(String symbol) {
        for (OperationType operationType : OperationType.values()) {
            if (operationType.symbol.equals(symbol)) {
                return operationType;
            }
        }
        return UNKNOWN;
    }

    public int apply(int a, int b) {
        return operator.applyAsInt(a, b);
    }
}
