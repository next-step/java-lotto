package kr.heesu.calculator.enums;

public enum RegexPattern {
    DEFAULT_DELIMETER("[,:]"),
    DELIMETER_CONDITION("//[^0-9]\n");

    private final String pattern;

    RegexPattern(String pattern) {
        this.pattern = pattern;
    }

    public String of() {
        return this.pattern;
    }
}
