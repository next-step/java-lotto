package operator;

public enum Operator {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String operator;

    Operator(String operator) {
        this.operator = operator;
    }

    public static Operator fromSymbol(String symbol) {
        for (Operator op : Operator.values()) {
            if (op.operator.equals(symbol)) {
                return op;
            }
        }
        throw new IllegalArgumentException("유효하지 않은 연산자입니다: " + symbol);
    }
}
