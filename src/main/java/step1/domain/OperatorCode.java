package step1.domain;

import java.util.function.BiFunction;

public enum OperatorCode {
    PLUS("+", (num1, num2) -> num1 + num2),
    MINUS("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> num1 / num2);

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> expression;

    OperatorCode(String operator, BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public static OperatorCode ofCode(String operator) {
        for (OperatorCode operatorCode : OperatorCode.values()) {
            if (operatorCode.operator.equals(operator)) {
                return operatorCode;
            }
        }
        throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
    }

    public int calculate(int num1, int num2) {
        return this.expression.apply(num1, num2);
    }
    
}
