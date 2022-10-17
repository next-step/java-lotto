package lotto;

public enum OperatorType {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLE("*"),
    DIVIDE("/");

    private final String type;

    OperatorType(String type) {
        this.type = type;
    }

    public String type() {
        return type;
    }
}
