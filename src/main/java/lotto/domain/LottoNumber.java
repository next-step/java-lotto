package lotto.domain;

import java.util.Objects;

public class LottoNumber {

    public static final int LOTTO_NUMBER_MINIMUM = 1;
    public static final int LOTTO_NUMBER_MAXIMUM = 45;

    private final int number;

    public LottoNumber(int number) {
        validateNumberRange(number);
        this.number = number;
    }

    private void validateNumberRange(int number) {
        if (number < LOTTO_NUMBER_MINIMUM || number > LOTTO_NUMBER_MAXIMUM) {
            String msg = String.format("로또 숫자의 범위는 %d ~ %d 입니다.", LOTTO_NUMBER_MINIMUM, LOTTO_NUMBER_MAXIMUM);
            throw new IllegalArgumentException(msg);
        }
    }

    public int getNumber() {
        return number;
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