package com.nextstep.camp.lotto.domain.vo;

import com.nextstep.camp.lotto.domain.exception.LottoNumberOutOfRangeException;

import java.util.Objects;

public class LottoNumber {
    private final int value;

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;

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
