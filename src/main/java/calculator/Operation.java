package calculator;

public enum Operation {

    PLUS("+"),
    MINUS("-"),
    MULTIPLICATION("*"),
    DIVISION("/");

    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    public static boolean isOperation(String input) {
        boolean isOperation = false;
        for(Operation operation : Operation.values()) {
            String actual = operation.symbol;
            isOperation = actual.equals(input);
        }
        return isOperation;
    }
}
