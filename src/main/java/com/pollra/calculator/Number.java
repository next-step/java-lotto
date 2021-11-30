package com.pollra.calculator;

import java.util.Objects;

/**
 * @since       2021.11.29
 * @author      pollra
 **********************************************************************************************************************/
public class Number {

    private static final int DEFAULT_VALUE = 0;

    private final int value;

    public Number() {
        this(DEFAULT_VALUE);
    }

    public Number(String text) {
        boolean isDigit = text.chars().allMatch(Character::isDigit);
        if( ! isDigit) {
            throw new RuntimeException("음수 및 문자열은 계산할 수 없습니다.");
        }
        value = Integer.parseInt(text);
    }

    public Number(int value) {
        this.value = value;
    }

    public Number plus(Number otherNumber) {
        return new Number(value + otherNumber.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (! (o instanceof Number)) return false;
        Number number=(Number) o;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
