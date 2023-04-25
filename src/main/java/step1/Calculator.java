package step1;

import java.util.Arrays;

public enum Calculator {

    PLUS("+", (a, b) -> a + b),

    MINUS("-", (a, b) -> a - b),

    MULTIPLY("*", (a, b) -> a * b),

    DIVIDE("/", (a, b) -> a / b);

    private final String operator;
    private final CalculatorFunction function;

    Calculator(String operator, CalculatorFunction function) {
        this.operator = operator;
        this.function = function;
    }

    public int calculate(int a, int b) {
        return function.calculate(a, b);
    }

    public static Calculator findOperator(String operator) {
        return Arrays.stream(values())
                .filter(calculator -> calculator.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(operator + "는 사칙연산의 기호가 아닙니다."));
    }
}
