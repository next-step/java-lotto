package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    MULTIPLY("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);

    private final String symbol;
    private final BiFunction<Integer, Integer, Integer> expression;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> expression) {
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
        int firstNumber = first.getNumber();
        int secondNumber = second.getNumber();
        Integer apply = expression.apply(firstNumber, secondNumber);

        return new Number(apply);
    }

}

