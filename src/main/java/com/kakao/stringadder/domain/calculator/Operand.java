package com.kakao.stringadder.domain.calculator;

import java.util.Objects;

public class Operand {
    private final int value;

    public Operand(int value) {
        validate(value);
        this.value = value;
    }

    public static Operand of(String input) {
        try {
            return new Operand(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바르지 않은 피연산자 타입입니다.");
        }
    }

    public static Operand zero() {
        return new Operand(0);
    }

    public int getValue() {
        return value;
    }

    public Operand plus(Operand operand) {
        return new Operand(value + operand.value);
    }

    private void validate(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("음수는 계산할 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operand operand = (Operand) o;
        return value == operand.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
