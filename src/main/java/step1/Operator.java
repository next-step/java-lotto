package step1;

import java.util.function.BinaryOperator;

public enum Operator {

    ADD("+", (first, second) -> first + second),
    SUBTRACT("-", (first, second) -> first - second),
    MULTIPLY("*", (first, second) -> first * second),
    DIVIDE("/", (first, second) -> first / second),
    ;
    private final String value;
    private final BinaryOperator<Integer> operation;

    Operator(String value, BinaryOperator<Integer> operation) {
        this.value = value;
        this.operation = operation;
    }

    public String getValue() {
        return value;
    }

    public BinaryOperator<Integer> getOperationStrategy() {
        return operation;
    }
}
