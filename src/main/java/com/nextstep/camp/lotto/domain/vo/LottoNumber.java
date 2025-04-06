package com.nextstep.camp.lotto.domain.vo;

import java.util.Objects;

import com.nextstep.camp.lotto.domain.exception.LottoNumberOutOfRangeException;

public class LottoNumber {
    private final int value;

    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;

    private LottoNumber(int value) {
        validate(value);
        this.value = value;
    }

    private static void validate(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new LottoNumberOutOfRangeException();
        }
    }

    public static LottoNumber of(int value) {
        return new LottoNumber(value);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
