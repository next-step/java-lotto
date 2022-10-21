package calculator.domain;

import java.util.function.BinaryOperator;

public enum Operation {
    PLUS("+", (a, b) -> (a + b)),
    MINUS("-", (a, b) -> (a - b)),
    MULTIPLICATION("*", (a, b) -> (a * b)),
    DIVISION("/",(a, b) -> (a / b));

    private final String operator;
    private final BinaryOperator<Integer> calculator;

    Operation(String operator, BinaryOperator<Integer> calculator) {
        this.operator = operator;
        this.calculator = calculator;
    }

    public String getOperator() {
        return operator;
    }

    public BinaryOperator<Integer> getCalculator() {
        return calculator;
    }
}
