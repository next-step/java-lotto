package camp.nextstep.edu.calculator;

import java.util.Arrays;

public enum Operator {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String operator;

    Operator(String operator) {
        this.operator = operator;
    }

    static Operator from(String operator) {
        return Arrays.stream(Operator.values())
            .filter(op -> op.operator.equals(operator))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("지원하지 않는 잘못된 연산자입니다."));
    }

    int operate(int left, int right) {
        if ("+".equals(this.operator)) {
            return left + right;
        }
        if ("-".equals(this.operator)) {
            return left - right;
        }
        if ("*".equals(this.operator)) {
            return left * right;
        }
        return left / right;
    }

}
