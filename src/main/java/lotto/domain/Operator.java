package lotto.domain;

public enum Operator {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String value;

    Operator(String value) {
        this.value = value;
    }

    public static Operator fromValue(String value) {
        for (Operator op : Operator.values()) {
            if (op.value.equals(value)) {
                return op;
            }
        }
        throw new IllegalArgumentException();
    }
}
