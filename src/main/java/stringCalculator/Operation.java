package stringCalculator;

public enum Operation {
    ADD("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String operation;

    Operation(String operation) {
        this.operation = operation;
    }

    public boolean isAddOperaiton(String[] strings, int i) {
        return ADD.operation.equals(strings[i - 1]);
    }

    public boolean isMinusOperaiton(String[] strings, int i) {
        return MINUS.operation.equals(strings[i - 1]);
    }

    public boolean isMultiplyOperation(String[] strings, int i) {
        return MULTIPLY.operation.equals(strings[i - 1]);
    }

    public boolean isDivideOperation(String[] strings, int i) {
        return DIVIDE.operation.equals(strings[i - 1]);
    }

    public int apply(int a, int b) {
        switch (this) {
            case ADD:
                return a + b;
            case MINUS:
                return a - b;
            case MULTIPLY:
                return a * b;
            case DIVIDE:
                return a / b;
        }
        throw new AssertionError("Unknown op: " + this);
    }

    public String getOperation() {
        return operation;
    }
}
