package stringCalculator.domain;

import java.util.function.BiFunction;

public enum Arithmetic {

    PLUS("+", (num1, num2) -> num1 + num2),
    SUBTRACT("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> num1 / num2);

    private BiFunction<Integer, Integer, Integer> expression;
    private String arithmetic;

    Arithmetic(String arithmetic, BiFunction<Integer, Integer, Integer> expression) {
        this.arithmetic = arithmetic;
        this.expression = expression;
    }

    public int calculate(int num1, int num2){
        return expression.apply(num1, num2);
    }
}
