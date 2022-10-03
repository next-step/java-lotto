package calculator;

import java.util.Arrays;

public enum OperatorEnum {

    ADD("+", AddOperator.getInstance()),
    SUBSTRACT("-", SubstractOperator.getInstance()),
    MULTIPLY("*", MultiplyOperator.getInstance()),
    DIVIDE("/", DivideOperator.getInstance());

    private final String token;
    private final Operator operator;

    OperatorEnum(String token, Operator operator) {
        this.token = token;
        this.operator = operator;
    }

    public static Operator getOperator(String operation) {
        return Arrays.stream(values())
                .filter(operatorEnum -> operatorEnum.token.equals(operation))
                .map(operatorEnum -> operatorEnum.operator)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("올바르지 않은 연산자입니다."));
    }
}
