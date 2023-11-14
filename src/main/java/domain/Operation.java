package domain;

import java.util.function.IntBinaryOperator;

public enum Operation {
    ADD((a, b) -> a + b),
    SUBTRACT((a, b) -> a - b),
    MULTIPLY((a, b) -> a * b),
    DIVIDE((a, b) -> a / b),
    ;

    private final IntBinaryOperator operation;

    Operation(IntBinaryOperator intBinaryOperator) {
        this.operation = intBinaryOperator;
    }
    public int calculate(int operand1, int operand2) {
        return operation.applyAsInt(operand1, operand2);
    }
}
