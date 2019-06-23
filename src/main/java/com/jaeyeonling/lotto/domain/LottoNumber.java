package com.jaeyeonling.lotto.domain;

import com.jaeyeonling.lotto.exception.LottoNumberLongerThanMaxException;
import com.jaeyeonling.lotto.exception.LottoNumberShorterThanMinException;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    public static final int MIN = 1;
    public static final int MAX = 45;

    private final int number;

    public LottoNumber(final int number) {
        if (number < MIN) {
            throw new LottoNumberShorterThanMinException(number);
        }
        if (number > MAX) {
            throw new LottoNumberLongerThanMaxException(number);
        }

        this.number = number;
    }

    @Override
    public int compareTo(final LottoNumber o) {
        return number - o.number;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoNumber)) {
            return false;
        }

        final LottoNumber that = (LottoNumber) o;
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
