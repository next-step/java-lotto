package calculator.string.domain;

import java.util.ArrayList;

public enum CalculatorSign {
    ADD("+"),
    SUB("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String sign;

    CalculatorSign(String sign) {
        this.sign = sign;
    }

    public String sign() {
        return sign;
    }

    public static CalculatorSign fromString(String sign) {
        switch(sign) {
            case "+":
                return ADD;
            case "-":
                return SUB;
            case "*":
                return MULTIPLY;
            case "/":
                return DIVIDE;
            default:
                throw new IllegalArgumentException("Calculator Enum 에 해당하는 값이 아닙니다.");
        }
    }

}
