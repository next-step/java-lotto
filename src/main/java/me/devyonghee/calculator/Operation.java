package me.devyonghee.calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

enum Operation {

    PLUS("+", PlusCalculator::of),
    MINUS("-", MinusCalculator::of),
    DIVIDE("/", DivideCalculator::of),
    MULTIPLY("*", MultiplyCalculator::of);

    private final String symbol;
    private final BiFunction<Calculator, Number, Calculator> calculatorFactory;

    Operation(String symbol, BiFunction<Calculator, Number, Calculator> calculatorFactory) {
        this.symbol = symbol;
        this.calculatorFactory = calculatorFactory;
    }

    static Operation of(String symbol) {
        return Arrays.stream(Operation.values())
                .filter(operation -> operation.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("Operation Symbol(%s) is not supported", symbol)));
    }

    Calculator calculator(Calculator calculator, Number number) {
        return calculatorFactory.apply(calculator, number);
    }
}
