package me.daeho.lotto.domain;

import java.util.Objects;
import java.util.Random;

public class LottoNumber {
    private final static Random GENERATOR = new Random();
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

    public static LottoNumber random() {
        return new LottoNumber(getRandomNumber());
    }

    public int value() {
        return value;
    }

    private static int getRandomNumber() {
        return GENERATOR.nextInt(MAX_VALUE) + 1;
    }

    private static void validateLottoNumber(int value) {
        if(value > MAX_VALUE || value < MIN_VALUE)
            throw new IllegalArgumentException();
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
