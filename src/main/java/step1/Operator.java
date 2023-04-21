package step1;

public enum Operator {
    PLUS("+"), MINUS("-"), MULTIPLY("*"), DIVIDE("/");

    private final String value;

    Operator(String value) {
        this.value = value;
    }

    public boolean isEqual(String operator) {
        return value.equals(operator);
    }
}
