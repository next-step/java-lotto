package calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.IntBinaryOperator;

public enum Calculator {

    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> {
        if (b == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return a / b;
    });

    private static final Map<String, Calculator> BY_OPERATOR = new HashMap<>();
    static {
        for (Calculator calculator : values()) {
            BY_OPERATOR.put(calculator.operator, calculator);
        }
    }

    private String operator;
    private IntBinaryOperator intBinaryOperator;

    Calculator(String operator, IntBinaryOperator intBinaryOperator) {
        this.operator = operator;
        this.intBinaryOperator = intBinaryOperator;
    }

    public static Calculator valueOfOperator(String operator) {
        return BY_OPERATOR.get(operator);
    }

    public int calculate(int a, int b) {
        return intBinaryOperator.applyAsInt(a, b);
    }
}
