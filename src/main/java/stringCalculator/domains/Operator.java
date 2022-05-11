package stringCalculator.domains;

import java.util.Arrays;

public class Operator {
    private final char operator;

    public Operator(String operator) {
        if (operator == null || operator.isEmpty()) {
            throw new IllegalArgumentException("연산자는 빈 값일 수 없습니다.");
        }

        if (operator.length() != 1) {
            throw new IllegalArgumentException("문자열의 길이는 1이여야 합니다.");
        }

        if (!Arrays.asList("+", "-", "*", "/").contains(operator)) {
            throw new IllegalArgumentException("사칙연산자가 아닙니다.");
        }

        this.operator = operator.charAt(0);
    }

    public int operate(int operand1, int operand2) {
        if (this.operator == '+') {
            return operand1 + operand2;
        }
        if (this.operator == '-') {
            return operand1 - operand2;
        }
        if (this.operator == '*') {
            return operand1 * operand2;
        }
        return operand1 / operand2;
    }
}
