package calculator.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.function.IntBinaryOperator;

public enum Operator {
    ADD("+", (num1, num2) -> num1 + num2),
    SUB("-", (num1, num2) -> num1 - num2),
    MULTI("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> num1 / num2);

    private static final Map<String, Operator> OPERATORS = new HashMap<>();

    private String operator;
    private IntBinaryOperator expression;

    static {
        for (Operator operator : values()) {
            OPERATORS.put(operator.operator, operator);
        }
    }

    Operator(String operator, IntBinaryOperator expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public static Operator from(String operator) {
        if (!OPERATORS.containsKey(operator)) {
            throw new IllegalArgumentException("Invalid operator: " + operator);
        }
        return OPERATORS.get(operator);
    }

    public int operate(int num1, int num2) {
        return expression.applyAsInt(num1, num2);
    }
}
