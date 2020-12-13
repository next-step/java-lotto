package com.nextstep.lotto.domain;

public class LottoNumber {
    private static final int NUMBER_MIN = 1;
    private static final int NUMBER_MAX = 45;

    private final int number;

    public LottoNumber(int number) {
        if (number < NUMBER_MIN || number > NUMBER_MAX) {
            throw new IllegalArgumentException("number shoud be between 1 and 45");
        }
        this.number = number;
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
