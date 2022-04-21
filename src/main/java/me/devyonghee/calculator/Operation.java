package me.devyonghee.calculator;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

enum Operation {

    PLUS("+", Number::plus),
    MINUS("-", Number::minus),
    DIVIDE("/", Number::divide),
    MULTIPLY("*", Number::multiply);

    private final String symbol;
    private final BiFunction<Number, Number, Number> calculator;

    Operation(String symbol, BinaryOperator<Number> calculator) {
        this.symbol = symbol;
        this.calculator = calculator;
    }

    static Operation of(String symbol) {
        return Arrays.stream(Operation.values())
                .filter(operation -> operation.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("Operation Symbol(%s) is not supported", symbol)));
    }

    Number calculatedNumber(Number number, Number target) {
        return calculator.apply(number, target);
    }
}
