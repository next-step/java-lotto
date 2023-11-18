package calculator.domain;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum Operator {
    PLUS("+", Number::plus),
    MINUS("-", Number::minus),
    MULTIPLY("*", Number::multiply),
    DIVISION("/", Number::divide);

    private final String symbol;
    private final BinaryOperator<Number> operation;

    Operator(String symbol, BinaryOperator<Number> operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public Number apply(Number leftOperand, Number rightOperand) {
        return operation.apply(leftOperand, rightOperand);
    }

    public static Operator fromSymbol(String symbol) {
        return Arrays.stream(Operator.values())
                .filter(op -> op.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 연산자가 아닙니다: " + symbol));
    }

    @Override
    public String toString() {
        return symbol;
    }
}
