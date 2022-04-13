package calculator.operation;

public enum ArithmeticOperation {

    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/");

    private final String operation;

    ArithmeticOperation(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }
}
