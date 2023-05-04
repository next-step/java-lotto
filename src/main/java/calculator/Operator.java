package calculator;

import java.util.EnumSet;

public enum Operator {

    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/"),

    ;

    private static final String NOT_FOUND_EXCEPTION_TEXT = "연산자를 찾을 수 없습니다.";

    private final String operator;


    Operator(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    public static Operator findByOperator(String operator) {
        return EnumSet.allOf(Operator.class)
                .stream()
                .filter(op -> op.getOperator().equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_EXCEPTION_TEXT));
    }

}
