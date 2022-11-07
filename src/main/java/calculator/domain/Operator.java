package calculator.domain;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;


import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (num1, num2) -> num1 + num2),
    MINUS("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> {
        checkZeroOf(num2);
        return num1 / num2;
    });


    private String symbol;
    private BiFunction<Integer, Integer, Integer> expression;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> expression) {
        this.symbol = symbol;
        this.expression = expression;
    }

    public int operate(int num1, int num2) {

                return expression.apply(num1, num2);

    }

    public static Operator of(String symbol) {
        return Arrays.stream(values())
                .filter(operator -> operator.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("피연산자 기호가 아닙니다."));
    }


    private static void checkZeroOf(int number) {
        if (number == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
    }
}
