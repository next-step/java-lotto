package step1;

import java.util.Arrays;
import java.util.regex.Pattern;

public enum OperatorType {

    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private static final String NOT_NUMBER_PATTERN = "^[0-9]*$";

    private String operator;

    OperatorType(String operator) {
        this.operator = operator;
    }

    static boolean isOperator(String operator){
        if (Pattern.matches(NOT_NUMBER_PATTERN, operator)) {
            return false;
        }

        return true;
    }

    String getOperator() {
        return operator;
    }

    static OperatorType getOperator(String operator) {
        return Arrays.stream(OperatorType.values())
                .filter(operatorTypeType -> operatorTypeType.getOperator().equals(operator))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("사칙연산만 가능합니다."));
    }
}
