package step1;

public enum OperatorType {

    PLUS("+"),
    MINUS("-"),
    TIMES("*"),
    DIVISION("/");

    private final String value;

    OperatorType(String value) {
        this.value = value;

    }

    public String getValue() {
        return value;
    }
}
