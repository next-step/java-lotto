package com.lotto.domain;

import com.lotto.exception.LottoNumberOutOfBoundsException;

import java.util.Objects;

public final class LottoNumber implements Comparable<LottoNumber> {
    public static final int LOTTO_START_NUMBER = 1;
    public static final int LOTTO_END_NUMBER = 45;

    private int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < LOTTO_START_NUMBER || number > LOTTO_END_NUMBER) {
            throw new LottoNumberOutOfBoundsException(number);
        }
    }

    public int number() {
        return number;
    }

    @Override
    public int compareTo(LottoNumber otherNumber) {
        return this.number - otherNumber.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
