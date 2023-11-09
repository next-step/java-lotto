package step1.domain;

import step1.exception.NotOperatorException;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {

    PLUS("+", (num1, num2) -> num1 + num2),
    MINUS("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> num1 / num2);

    private final String symbol;
    private final BiFunction<Integer, Integer, Integer> expression;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> expression) {
        this.symbol = symbol;
        this.expression = expression;
    }

    public static Operator of(String symbol) {
        return Arrays.stream(Operator.values())
            .filter(operator -> symbol.equals(operator.symbol))
            .findFirst()
            .orElseThrow(() -> new NotOperatorException());
    }

    public Integer calculation(Integer num1, Integer num2) {
        return expression.apply(num1, num2);
    }

}
