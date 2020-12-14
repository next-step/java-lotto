package com.nextstep.lotto.domain;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoNumber {
    public static final int MIN = 1;
    public static final int MAX = 45;
    private static final Map<Integer,LottoNumber> DEFINE_NUMBERS = Stream.iterate(MIN, i -> i + 1)
            .limit(MAX).collect(Collectors.toMap(Integer::intValue, LottoNumber::new));

    private final int number;

    private LottoNumber(int number){
        this.number = number;
    }

    public static LottoNumber of(int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException("number shoud be between 1 and 45");
        }
        return DEFINE_NUMBERS.get(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
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
        return number;
    }
}
