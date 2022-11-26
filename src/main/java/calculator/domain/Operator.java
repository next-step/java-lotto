package calculator.domain;

import java.util.List;

public class Operator {
    private static final List<String> ALLOWED_OPERATORS = List.of("+", "-", "*", "/");
    private final String operator;

    public Operator(String operator) {
        validateOperator(operator);
        this.operator = operator;
    }

    public int calculate(Integer number, Integer otherNumber) {
        switch (operator) {
            case "+":
                return number + otherNumber;
            case "-":
                return  number - otherNumber;
            case "*":
                return number * otherNumber;
            case "/":
                return number / otherNumber;
            default:
                throw new IllegalArgumentException("알 수 없는 사칙연산 기호입니다");
        }
    }

    private void validateOperator(String operator) {
        if (!ALLOWED_OPERATORS.contains(operator)) {
            throw new IllegalArgumentException("허용되지 않은 사칙연산 기호입니다");
        }
    }
}
