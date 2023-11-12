package study.step1.domain.type;

import java.util.Arrays;

public enum Operator {

    PLUS("+", "더하기"),
    MINUS("-", "빼기"),
    TIMES("*", "곱하기"),
    DIVIDE("/", "나누기");

    private final String code;
    private final String message;

    Operator(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public static Operator valueOfCode(String code) {
        return Arrays.stream(values())
            .filter(operator -> code.equals(operator.getCode()))
            .findAny()
            .orElse(null);
    }

    public boolean isPlus() {
        return this == PLUS;
    }

    public boolean isMinus() {
        return this == MINUS;
    }

    public boolean isTimes() {
        return this == TIMES;
    }

    public boolean isDivide() {
        return this == DIVIDE;
    }
}
