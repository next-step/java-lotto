package com.seok2.lotto.domain;

import com.seok2.lotto.exception.LottoOutOfBoundException;
import java.util.Objects;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {


    private static final LottoNumber[] CACHE = IntStream.rangeClosed(Lotto.LOTTO_MIN_NUMBER, Lotto.LOTTO_MAX_NUMBER)
        .mapToObj(LottoNumber::new)
        .toArray(LottoNumber[]::new);

    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(int number) {
        try {
            return CACHE[--number];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new LottoOutOfBoundException();
        }
    }

    @Override
    public int compareTo(LottoNumber that) {
        return number - that.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
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
