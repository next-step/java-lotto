package StringCalculator.domain;

import java.util.function.BiFunction;

public enum Operator {
    ADD("+", (a, b) -> a + b),
    SUBTRACT("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    });

    private final String symbol;
    private final BiFunction<Integer, Integer, Integer> operation;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> operation) {
        if (isInvalidOperator(symbol)) {
            throw new IllegalArgumentException("유효하지 않은 연산자입니다: " + symbol);
        }
        this.symbol = symbol;
        this.operation = operation;
    }

    private static boolean isInvalidOperator(String symbol) {
        return !symbol.matches("[\\+\\-\\*/]");
    }

    public String getSymbol() {
        return symbol;
    }

    public boolean isDivision() {
        return this == DIVIDE;
    }

    public int apply(int a, int b) {
        return operation.apply(a, b);
    }

    @Override
    public String toString() {
        return symbol;
    }

    public static Operator fromSymbol(String symbol) {
        for (Operator operator : values()) {
            if (operator.getSymbol().equals(symbol)) {
                return operator;
            }
        }
        throw new IllegalArgumentException("Invalid operator: " + symbol);
    }
}
