package calculator.operation;

public enum ArithmeticOperation {

    ADDITION("+", new Addition()),
    SUBTRACTION("-", new Subtraction()),
    MULTIPLICATION("*", new Multiplication()),
    DIVISION("/", new Division());

    private final String operation;
    private final CustomOperation customOperation;

    ArithmeticOperation(String operation, CustomOperation customOperation) {
        this.operation = operation;
        this.customOperation = customOperation;
    }

    public String getOperation() {
        return operation;
    }

    public CustomOperation getCustomOperation() {
        return customOperation;
    }
}
