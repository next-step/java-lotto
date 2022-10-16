package com.game.lotto.number;


public class LottoNumber {
    public static final int MAX_VALUE_OF_LOTTO_NUMBER = 45;
    public static final int MIN_VALUE_OF_LOTTO_NUMBER = 1;

    private final int number;

    public LottoNumber(int number) {
        if (number < MIN_VALUE_OF_LOTTO_NUMBER || number > MAX_VALUE_OF_LOTTO_NUMBER) {
            throw new IllegalArgumentException("올바른 로또 번호가 아닙니다! (" + MIN_VALUE_OF_LOTTO_NUMBER + "~" + MAX_VALUE_OF_LOTTO_NUMBER + ")");
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public int compareTo(LottoNumber lottoNumber) {
        return number - lottoNumber.getNumber();
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

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
