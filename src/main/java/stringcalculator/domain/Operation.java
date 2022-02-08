package stringcalculator.domain;

import java.util.function.BiFunction;

public enum Operation {

    PLUS((number1, number2) -> number1 + number2),
    MINUS((number1, number2) -> number1 - number2);

    private final BiFunction<Integer, Integer, Integer> operator;

    Operation(final BiFunction<Integer, Integer, Integer> operator) {
        this.operator = operator;
    }

    public int operate(final int number1, final int number2) {
        return operator.apply(number1, number2);
    }
}
