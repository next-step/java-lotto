package calculator.operator;

public enum OperatorEnum {
    ADD("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String value;

    OperatorEnum(String value) {
        this.value = value;
    }
}
