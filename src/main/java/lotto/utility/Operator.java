package lotto.utility;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum Operator {
    PLUS("+", (operand1, operand2) -> operand1 + operand2),
    MINUS("-", (operand1, operand2) -> operand1 - operand2),
    MULTIPLY("*", (operand1, operand2) -> operand1 * operand2),
    DIVIDE("/", (operand1, operand2) -> operand1 / operand2);

    private final String symbol;
    private final BinaryOperator<Double> operation;

    Operator(String symbol, BinaryOperator<Double> operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public Double compute(double a, double b) {
        return this.operation.apply(a, b);
    }

    public static Operator from(String symbol) {
        return Arrays.stream(values())
                .filter(operator -> operator.symbol.equals(symbol))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 연산자입니다"));
    }
}