package calculator.code;

import java.util.Arrays;

public enum MathSign {
    PLUS ("+"),
    MINUS ("-"),
    MULTIPLY ("*"),
    DIVIDE ("/");

    private final String sign;

    MathSign(String sign) {
        this.sign = sign;
    }

    public String sign(){
        return this.sign;
    }

    public static MathSign fromSign(String inputSign) {
        return Arrays.stream(values())
                .filter(sign -> sign.sign.equals(inputSign))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바르지 않은 연산 기호입니다."));
    }

}
