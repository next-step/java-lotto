package me.daeho.lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {
    private final static int MAX_VALUE = 45;
    private final static int MIN_VALUE = 1;
    private final int value;

    private LottoNumber(int value) {
        validateLottoNumber(value);
        this.value = value;
    }

    public static LottoNumber of(int value) {
        return new LottoNumber(value);
    }

    public int value() {
        return value;
    }

    public static List<Integer> availableNumbers() {
        return IntStream.range(MIN_VALUE, MAX_VALUE)
                .boxed()
                .collect(Collectors.toList());
    }

    private static void validateLottoNumber(int value) {
        if(value > MAX_VALUE || value < MIN_VALUE)
            throw new IllegalArgumentException("로또 번호 범위를 초과하였습니다.");
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
        return String.valueOf(value);
    }
}
