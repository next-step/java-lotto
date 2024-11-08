package stringcalculator;

import java.util.Arrays;

public enum FourBasicOperatorEnum {
    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/");

    private final String value;

    private FourBasicOperatorEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static boolean isValid(String value) {
        return Arrays.stream(FourBasicOperatorEnum.values())
                .anyMatch(fourBasicOperatorEnum -> fourBasicOperatorEnum.getValue().equals(value));
    }
}
