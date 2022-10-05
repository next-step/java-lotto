package com.nextstep.lotto;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public enum Operator {
    PLUS("+", (num1, num2) -> num1 + num2),
    MINUS("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> num1 / num2);

    private final String symbol;
    private final BiFunction<Integer, Integer, Integer> function;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> function) {
        this.symbol = symbol;
        this.function = function;
    }

    public static Operator of(String symbol) {
        Operator found = Arrays.stream(values())
                .filter(operator -> operator.symbol.equals(symbol))
                .findFirst()
                .orElseThrow((Supplier<RuntimeException>) () -> new IllegalArgumentException(""));
        return found;
    }

    public int apply(int leftOperand, int rightOperand) {
        return function.apply(leftOperand, rightOperand);
    }
}
