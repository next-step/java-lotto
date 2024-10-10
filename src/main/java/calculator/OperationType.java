package calculator;

import java.util.function.BinaryOperator;

public enum OperationType {
    ADD("+", Integer::sum),
    SUBTRACT("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a),
    DIVIDE("/", (a, b) -> a),
    UNKNOWN("UNKNOWN", (a, b) -> a);

    private final String symbol;
    private final BinaryOperator<Integer> operator;

    OperationType(String symbol, BinaryOperator<Integer> operator) {
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
        return operator.apply(a, b);
    }
}
