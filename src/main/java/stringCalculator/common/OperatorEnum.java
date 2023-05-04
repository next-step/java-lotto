package stringCalculator.common;

public enum OperatorEnum {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");
    
    private String code;

    OperatorEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }
}
