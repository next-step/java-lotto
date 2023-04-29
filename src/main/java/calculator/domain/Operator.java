package calculator.domain;

import calculator.Calculator;

import java.util.List;
import java.util.function.BiFunction;

public enum Operator {
    ADD("+", Calculator::add),
    SUBTRACT("-", Calculator::subtract),
    MULTIPLY("*", Calculator::multiply),
    DIVIDE("/", Calculator::divide);
    private String symbol;
    private BiFunction<Integer, Integer, Integer> expression;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> expression) {
        this.symbol = symbol;
        this.expression = expression;
    }

    public int apply(int number1, int number2) {
        return expression.apply(number1, number2);
    }

    static public Operator of(String symbol) {
        return List.of(Operator.values())
                .stream()
                .filter(operator -> operator.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("사칙연산 기호가 아닙니다."));
    }
}
