package step01.domain;

public enum Operation {
    ADDITION("+", Integer::sum),
    SUBTRACTION("-", (n1, n2) -> n1 - n2),
    MULTIPLICATION("*", (n1, n2) -> n1 * n2),
    DIVISION("/", (n1, n2) -> n1 / n2);

    private final String symbol;
    private final Operator operator;

    Operation(String symbol, Operator operator) {
        this.symbol = symbol;
        this.operator = operator;
    }

    public static Operator from(String symbol) {
        for (Operation operation : values()) {
            if (operation.symbol.equals(symbol)) {
                return operation.operator;
            }
        }
        throw new IllegalArgumentException("해당 문자는 연산자가 아닙니다. | symbol: " + symbol);
    }
}
