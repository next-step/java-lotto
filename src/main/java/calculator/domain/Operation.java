package calculator.domain;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum Operation {
    PLUS("+", NumberValue::plus),
    MINUS("-", NumberValue::minus),
    TIMES("*", NumberValue::times),
    DIVIDE("/", NumberValue::divide);

    private final String symbol;
    private final BinaryOperator<NumberValue> op;

    Operation(String symbol, BinaryOperator<NumberValue> op) {
        this.symbol = symbol;
        this.op = op;
    }

    public static Operation findBySymbol(final String symbol) {
        return Arrays.stream(values())
                .filter(v -> v.getSymbol().equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("사칙연산 기호가 아닙니다."));
    }

    public NumberValue apply(NumberValue x, NumberValue y) {
        return op.apply(x, y);
    }

    private String getSymbol() {
        return symbol;
    }
}
