package step1.enumeration;

public enum OperatorTypes {

    PLUS("+"),
    TAKE_OUT("-"),
    MULTIPLY("*"),
    DIVISION("/")
    ;

    private final String operator;

    OperatorTypes(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return this.operator;
    }
}
