package calculator;

import java.util.Arrays;

public enum OperatorEnum {
    ADD ("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private String value;

    OperatorEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static OperatorEnum getEnumByValue(String inputValue) {
        return Arrays.stream(values()).filter(e -> e.getValue().equals(inputValue)).findFirst().orElse(null);
    }

}
