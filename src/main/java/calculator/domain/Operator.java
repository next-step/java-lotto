package calculator.domain;

import java.util.function.BiFunction;

public enum Operator {

    ADD("+", (a, b) -> a + b),
    SUBTRACT("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> {
        if (b == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return a / b;
    });

    private final String symbol;
    private final BiFunction<Integer, Integer, Integer> operation;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public static Operator fromSymbol(String symbol) {
        for (Operator operator : values()) {
            if (operator.symbol.equals(symbol)) {
                return operator;
            }
        }
        throw new IllegalArgumentException("유효하지 않은 연산자: " + symbol);
    }

    public int apply(int a, int b) {
        return operation.apply(a, b);
    }

    public String getSymbol() {
        return symbol;
    }
}
