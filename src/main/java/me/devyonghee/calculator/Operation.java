package me.devyonghee.calculator;

import java.util.Arrays;

public enum Operation {

    PLUS("+"),
    MINUS("-"),
    DIVIDE("/"),
    MULTIPLY("*");

    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    static Operation of(String symbol) {
        return Arrays.stream(Operation.values())
                .filter(operation -> operation.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("Operation Symbol(%s) is not supported", symbol)));
    }

    public boolean isPlus() {
        return this == PLUS;
    }

    public boolean isMinus() {
        return this == MINUS;
    }

    public boolean isDivide() {
        return this == DIVIDE;
    }

    public boolean isMultiply() {
        return this == MULTIPLY;
    }
}
