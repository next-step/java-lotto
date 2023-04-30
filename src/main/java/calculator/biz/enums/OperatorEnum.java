package calculator.biz.enums;

public enum OperatorEnum {

    PLUS("+"),
    MINUS("-"),
    DIVIDE("/"),
    MULTIPLY("*");

    private String value;

    OperatorEnum(String value) {
        this.value = value;
    }


    public String getValue() {
        return value;
    }
}
