package domain;

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
        if (PLUS.symbol.equals(input)) return Operator.PLUS;
        if (MINUS.symbol.equals(input)) return Operator.MINUS;
        if (MULTIPLE.symbol.equals(input)) return Operator.MULTIPLE;
        if (DIVIDE.symbol.equals(input)) return Operator.DIVIDE;
        throw new IllegalArgumentException();
    }

    public int apply(int a, int b) {
        return operation.applyAsInt(a, b);
    }
}
