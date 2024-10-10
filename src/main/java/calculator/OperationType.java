package calculator;

public enum OperationType {
    ADD("+"), SUBTRACT("-"), MULTIPLY("*"), DIVIDE("/"), UNKNOWN("UNKNOWN");

    private final String symbol;

    OperationType(String symbol) {
        this.symbol = symbol;
    }

    public static OperationType fromSymbol(String symbol) {
        for (OperationType operationType : OperationType.values()) {
            if (operationType.symbol.equals(symbol)) {
                return operationType;
            }
        }
        return UNKNOWN;
    }
}
