package kr.heesu.calculator.enums;

import java.util.regex.Pattern;

public enum  IllegalCondition {
    EMPTY(""),
    NEGATIVE("-[0-9]+");

    private final String condition;

    IllegalCondition(String condition) {
        this.condition = condition;
    }

    public String of() {
        return this.condition;
    }

    public static boolean matches(String input) {
        if (Pattern.matches(EMPTY.of(), input)) {
            return true;
        }

        if (Pattern.matches(NEGATIVE.of(), input)) {
            return true;
        }

        return false;
    }
}
