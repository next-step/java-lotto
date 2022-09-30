package arithmetic.operator;

enum Operator {
    ADDITION("+", new Addition()),
    SUBTRACTION("-", new Subtraction()),
    MULTIPLICATION("*", new Multiplication()),
    DIVISION("/", new Division());

    private final String symbol;
    private final Operation operation;

    Operator(String symbol, Operation operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public Operation getOperation() {
        return operation;
    }

    public static Operator of(String symbol) {
        for (Operator operator : values()) {
            if (operator.symbol.equals(symbol)) {
                return operator;
            }
        }
        throw new UnsupportedOperationException("Operator not supported.");
    }
}
