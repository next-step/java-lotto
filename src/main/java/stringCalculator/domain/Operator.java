package stringCalculator.domain;

import java.util.Arrays;

public class Operator {
    private final String[] OPERATIONS = {"+", "-", "*", "/"};
    private String operator;

    public Operator(String operator) {
        validate(operator);
        this.operator = operator;
    }

    private void validate(String operator) {
        if (!isOperator(operator)) {
            throw new IllegalArgumentException("유효한 연산자가 아닙니다.");
        }
    }

    private boolean isOperator(String operator) {
        return Arrays.asList(OPERATIONS).contains(operator);
    }

    public String getOperator() {
        return operator;
    }
}
