package stringCalculator.domain;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.function.BiFunction;

public enum NumericalExpression {
    PLUS("+", (a, b) -> a+b),
    SUBTRACT("-", (a, b) -> a-b),
    DIVIDE("/", (a, b) -> a/b),
    MULTIPLY("*", (a, b) -> a*b);

    private final String expression;
    private BiFunction<Integer, Integer, Integer> operator;

    NumericalExpression(String expression, BiFunction<Integer, Integer, Integer> operator) {
        this.expression = expression;
        this.operator = operator;
    }

    public static NumericalExpression valueOfNumericalExpression(String expression) {
        return Arrays.stream(values())
                .filter(value -> value.expression.equals(expression))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("유효한 연산자가 아닙니다"));
    }

    public Integer calculate(int leftNumber, int rightNumber) {
        if(this == DIVIDE && rightNumber == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다");
        }
        return operator.apply(leftNumber, rightNumber);
    }

}
