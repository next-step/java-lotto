package com.seok2.lotto.domain;

import com.seok2.lotto.exception.OutOfLottoLengthException;
import java.util.Objects;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final LottoNumber[] CACHE = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
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
            throw new OutOfLottoLengthException();
        }
    }

    @Override
    public String toString() {
        return String.valueOf(number);
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
    public int compareTo(LottoNumber number) {
        return this.number - number.number;
    }
}
