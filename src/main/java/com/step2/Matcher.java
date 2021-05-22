package com.step2;

public enum Matcher {
    DELIMITER(1), TOKENS(2);

    private int value;

    Matcher(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
