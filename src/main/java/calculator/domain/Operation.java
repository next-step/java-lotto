package calculator.domain;

import java.util.Arrays;
import java.util.function.DoubleBinaryOperator;

import static calculator.domain.Calculator.OPERATOR_VALIDATE;

public enum Operation {
    PLUS("+", (a,b) -> a + b),
    MULTIPLY("*", (a,b) -> a * b),
    SUBTRACT("-", (a,b) -> a - b),
    DIVIDE("/", (a,b) -> a / b),
    UNKNOWN(null, null);

    private final String operation;
    private final DoubleBinaryOperator op;

    private Operation(String operation, DoubleBinaryOperator op) {
        this.operation = operation;
        this.op = op;
    }

    private String getOperation() {
        return operation;
    }

    public static Operation findOperator(String operator) {
        return Arrays.stream(Operation.values())
                .filter(i -> i.getOperation().equals(operator))
                .findFirst()
                .orElse(Operation.UNKNOWN);
    }

    public int calculate(double x, double y) {
        return (int) op.applyAsDouble(x, y);
    }

}
