package lotto.step1.enums;

import lotto.step1.domain.MathOperation;

import java.util.Arrays;

public enum Operator {
    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLE("*", (a, b) -> a * b),
    DIVISION("/", (a, b) -> a / b);

    private String symbol;
    private MathOperation function;

    Operator(String symbol, MathOperation function) {
        this.symbol = symbol;
        this.function = function;
    }

    public String getSymbol() {
        return symbol;
    }

    public MathOperation getFunction() {
        return function;
    }

    public static MathOperation execute(String symbol) {
        final var operation = Arrays.stream(values())
                .filter(value -> value.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("일치하는 기호가 없습니다. : " + symbol));
        return operation.function;
    }

    }
