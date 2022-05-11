package caculator.domain;

import java.util.function.BiFunction;

public enum CalculatorType {
    PLUS("+", (num1, num2) -> num1 + num2),
    MINUS("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> num1 / num2);

    public static final int ZERO_NUMBER = 0;
    private String type;
    private BiFunction<Integer, Integer, Integer> expression;

    CalculatorType(String type, BiFunction<Integer, Integer, Integer> expression) {
        this.type = type;
        this.expression = expression;
    }

    public Integer calculate(int num1, int num2) {
        isDividedByZero(num2);
        return this.expression.apply(num1, num2);
    }

    public static CalculatorType selectType(String sign) {
        if (PLUS.type.equals(sign)) {
            return PLUS;
        }
        if (MINUS.type.equals(sign)) {
            return MINUS;
        }
        if (MULTIPLY.type.equals(sign)) {
            return MULTIPLY;
        }
        if (DIVIDE.type.equals(sign)) {
            return DIVIDE;
        }
        throw new IllegalArgumentException("제대로된 사칙연산기호를 입력해 주세요. 입력 값: " + sign);
    }

    private void isDividedByZero(int numberTwo) {
        if (this.type.equals("/") && numberTwo == ZERO_NUMBER) {
            throw new ArithmeticException("0으로 나눌수 없습니다.");
        }
    }
}
