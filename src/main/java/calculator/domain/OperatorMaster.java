package calculator.domain;

import calculator.exception.UnsupportedOperatorException;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public enum OperatorMaster {

    ADDITION("+", (operand1, operand2) -> operand1 + operand2),
    SUBTRACTION("-", (operand1, operand2) -> operand1 - operand2) ,
    MULTIPLICATION("*", (operand1, operand2) -> operand1 * operand2) ,
    DIVISION("/", (operand1, operand2) -> operand1 / operand2);
    ;

    private final String operator;
    private final IntBinaryOperator intBinaryOperator;

    OperatorMaster(String operator, IntBinaryOperator intBinaryOperator) {
        this.operator = operator;
        this.intBinaryOperator = intBinaryOperator;
    }

    public static int calculate(String operator, int operand1, int operand2) {
        OperatorMaster operatorMaster = findBy(operator);
        return operatorMaster.intBinaryOperator.applyAsInt(operand1, operand2);
    }

    private static OperatorMaster findBy(String operator) {
        return Arrays.stream(values())
                .filter(op -> op.isMatchingOperator(operator))
                .findFirst()
                .orElseThrow(() -> new UnsupportedOperatorException("지원하지 않는 연산자입니다."));
    }

    private boolean isMatchingOperator(String operator) {
        return this.operator.equals(operator);
    }

}

