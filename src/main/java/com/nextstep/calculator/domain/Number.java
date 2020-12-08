package com.nextstep.calculator.domain;

import com.nextstep.calculator.domain.exceptions.InvalidNumberException;

import java.util.Objects;

public class Number {
    private final Integer value;

    Number(final Integer value) {
        this.value = value;
    }

    public static Number of(final String value) {
        validate(value);
        Integer parsedNumber = parseSafely(value);
        validatePositive(parsedNumber);

        return new Number(parsedNumber);
    }

    public Number plus(Number thatNumber) {
        return new Number(this.value + thatNumber.value);
    }

    public Integer getValue() {
        return value;
    }

    private static Integer parseSafely(final String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new InvalidNumberException("숫자로 변환할 수 없는 유형입니다.");
        }
    }

    private static void validatePositive(final Integer number) {
        if (number < 0) {
            throw new InvalidNumberException("양수와 0만 Number 전환 가능합니다.");
        }
    }

    private static void validate(final String value) {
        if (value == null) {
            throw new InvalidNumberException("null은 Number로 전환할 수 없습니다.");
        }
        if (value.trim().isEmpty()) {
            throw new InvalidNumberException("빈 값은 Number로 전환할 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return Objects.equals(value, number.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Number{" +
                "value='" + value + '\'' +
                '}';
    }
}
