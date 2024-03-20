package calculator.domain;

import static calculator.domain.Calculator.OPERATOR_VALIDATE;

public enum Operation {
    PLUS("+"),
    MULTIPLY("*"),
    SUBTRACT("-"),
    DIVIDE("/");

    private final String operation;

    private Operation(String operation) {
        this.operation = operation;
    }

    private String getOperation() {
        return operation;
    }

    public static int from(int operand1, String operator, int operand2) {
        if (MULTIPLY.getOperation().equals(operator)) {
            return operand1 * operand2;
        }
        if (PLUS.getOperation().equals(operator)) {
            return operand1 + operand2;
        }
        if (SUBTRACT.getOperation().equals(operator)) {
            return operand1 - operand2;
        }
        if (DIVIDE.getOperation().equals(operator)) {
            return operand1 / operand2;
        }
        throw new IllegalArgumentException(OPERATOR_VALIDATE);
    }


}
