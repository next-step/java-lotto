package calculator;

import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLE("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b);

    private String operator;
    private BiFunction<Double, Double, Double> function;

    Operator(String operator, BiFunction<Double, Double, Double> function) {
        this.operator = operator;
        this.function = function;
    }

    public double calculate(double number1, double number2) {
        return function.apply(number1, number2);
    }

    public static Operator pars(String operatorInput) {
        for (Operator operator : Operator.values()) {
            Operator x = getOperator(operatorInput, operator);
            if (x != null) return x;
        }
        throw new IllegalArgumentException("연산자가 아닙니다.");
    }

    private static Operator getOperator(String operatorInput, Operator operator) {
        if (operatorInput.equals(operator.operator)) {
            return operator;
        }
        return null;
    }
}
