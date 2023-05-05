package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", Number::plus),
    MINUS("-", Number::minus),
    MULTIPLY("*", Number::multiply),
    DIVIDE("/", Number::divide);

    private final String symbol;
    private final BiFunction<Number, Number, Number> expression;

    Operator(String symbol, BiFunction<Number, Number, Number> expression) {
        this.symbol = symbol;
        this.expression = expression;
    }

    static Operator of(String symbol) {
        return Arrays.stream(Operator.values())
                .filter(operator -> operator.symbol.equals(symbol))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("해당 연산자는 사칙연사자가 아닙니다."));
    }

    Number calculateTwoNumber(Number first, Number second) {
        Number result = expression.apply(first, second);

        return result;
    }

}

