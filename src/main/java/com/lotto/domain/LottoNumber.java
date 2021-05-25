package com.lotto.domain;

import com.lotto.exception.LottoNumberOutOfBoundsException;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int LOTTO_START_NUMBER = 1;
    public static final int LOTTO_END_NUMBER = 45;

    private int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    public static LottoNumber valueOf(int number) {
        validate(number);
        return LottoNumberCache.cache[number - 1];
    }

    private static void validate(int number) {
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
        if (o == null || !(this instanceof LottoNumber)) return false;
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

    private static class LottoNumberCache {
        static final LottoNumber[] cache = new LottoNumber[45];

        static {
            for (int i = LOTTO_START_NUMBER - 1; i < LOTTO_END_NUMBER; i++) {
                cache[i] = new LottoNumber(i + 1);
            }
        }

        private LottoNumberCache() {
        }
    }
}
