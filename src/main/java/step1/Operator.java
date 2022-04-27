package step1;

public enum Operator {

    ADD("+", (a, b) -> a + b),
    SUBTRACT("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b),
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
