package calculator.domain;

import calculator.exception.DivisionResultFloatException;

public class Operator {
    public static final String ADDITION = "+";
    public static final String SUBTRACTION = "-";
    public static final String MULTIPLICATION = "*";
    public static final String DIVISION = "/";

    private final String operator;

    public Operator(String operator) {
        validate(operator);
        this.operator = operator;
    }

    private void validate(String operator) {
        if (operator.equals(ADDITION) || operator.equals(SUBTRACTION) || operator.equals(MULTIPLICATION) || operator.equals(DIVISION)) {
            return;
        }
        throw new IllegalArgumentException("지원하는 연산기호가 아닙니다.");
    }

    public int operate(int num1, int num2) {
        if (operator.equals(ADDITION)) {
            return num1 + num2;
        }
        if (operator.equals(SUBTRACTION)) {
            return num1 - num2;
        }
        if (operator.equals(MULTIPLICATION)) {
            return num1 * num2;
        }
        if (operator.equals(DIVISION)) {
            validateDivision(num1, num2);
            return num1 / num2;
        }
        return -1;
    }

    private void validateDivision(int num1, int num2) {
        if (num1 % num2 != 0) {
            throw new DivisionResultFloatException();
        }
    }
}
