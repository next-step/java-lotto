package com.kkambi.calculator.domain;

import java.util.function.Function;

public enum Operator {
    SUM(numbers -> numbers.getNumbers()
            .stream()
            .reduce(0, (sumResult, number) -> sumResult + number.getNumber(), Integer::sum));

    private final Function<Numbers, Integer> calculation;

    Operator(Function<Numbers, Integer> calculation) {
        this.calculation = calculation;
    }

    public int calculate(Numbers numbers) {
        return calculation.apply(numbers);
    }
}
