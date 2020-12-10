package com.nextstep.lotto.domain;

import com.nextstep.lotto.domain.exceptions.InvalidLottoNumberException;

import java.util.Objects;

public class LottoNumber {
    private static final int MIN_SIZE = 1;
    private static final int MAX_SIZE = 45;

    private final int value;

    LottoNumber(final int value) {
        validate(value);

        this.value = value;
    }

    public int getValue() {
        return value;
    }

    private void validate(final int value) {
        if (value < MIN_SIZE || value > MAX_SIZE) {
            throw new InvalidLottoNumberException("유효하지 않은 LottoNumber 입니다.");
        }
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
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "LottoNumber{" +
                "value=" + value +
                '}';
    }
}
