package step1;

import step1.impl.DivideStrategy;

public enum Operator {

    ADD("+", (a, b) -> a + b),
    SUBTRACT("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", new DivideStrategy()),
    ;
    private final String value;
    private final OperationStrategy operationStrategy;

    Operator(String value, OperationStrategy operationStrategy) {
        this.value = value;
        this.operationStrategy = operationStrategy;
    }

    public String getValue() {
        return value;
    }

    public OperationStrategy getOperationStrategy() {
        return operationStrategy;
    }
}
