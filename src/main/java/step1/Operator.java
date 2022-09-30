package step1;

import java.util.Arrays;

public enum Operator {

    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private String operator;

    Operator(String operator) {
        this.operator = operator;
    }

    static boolean isOperator(String operator){
        return Arrays.stream(Operator.values())
                .anyMatch(operatorType -> operatorType.getOperator().equals(operator));
    }

    String getOperator() {
        return operator;
    }
}
