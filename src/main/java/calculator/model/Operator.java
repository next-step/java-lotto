package calculator.model;

import java.util.List;

public class Operator {
    public static final List<String> OPERATOR = List.of("+", "-", "*", "/");
    private final List<String> operators;

    public List<String> operators() {
        return this.operators;
    }

    public Operator(List<String> operators) {
        this.operators = getOperator(operators);
    }

    private List<String> getOperator(List<String> operators) {
        isOperator(operators);
        return operators;
    }

    public static void isOperator(List<String> operators) {
        if (hasInvalidOperator(operators)) {
            throw new IllegalArgumentException("사칙연산 기호가 아닙니다 (+,-,*,/)");
        }
    }

    private static boolean hasInvalidOperator(List<String> operators) {
        return operators.stream().anyMatch(operator -> !OPERATOR.contains(operator));
    }
}
