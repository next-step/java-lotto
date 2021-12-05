package com.pollra.calculator;

import java.util.Objects;

/**
 * @since       2021.11.29
 * @author      pollra
 **********************************************************************************************************************/
public class Number {

    private static final String INTEGER_MATCHES_EXPRESSION = "-?\\d+";
    private static final int DEFAULT_VALUE = 0;

    private final int value;

    public Number() {
        this(DEFAULT_VALUE);
    }

    public Number(int value) {
        this.value = value;
    }

    public Number(String text) {
        if( ! text.matches(INTEGER_MATCHES_EXPRESSION)) {
            throw new RuntimeException("문자열은 숫자로 치환할 수 없습니다.");
        }
        if( ! text.chars()
                .allMatch(Character::isDigit)) {
            throw new RuntimeException("음수는 계산 대상이 아닙니다.");
        }
        value = Integer.parseInt(text);
    }

    public static boolean isNumber(String text) {
        return text.matches(INTEGER_MATCHES_EXPRESSION);
    }

    public static boolean notNumber(String text) {
        return ! isNumber(text);
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

    @Override
    public String toString() {
        return "Number{" +
                "value=" + value +
                '}';
    }
}
