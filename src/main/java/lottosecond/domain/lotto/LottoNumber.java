package lottosecond.domain.lotto;

import java.util.Objects;

public class LottoNumber {

    private static final int LOW_BOUND_LOTTO_NUMBER = 1;
    private static final int UPPER_BOUND_LOTTO_NUMBER = 45;

    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(int number) {
        if (number < LOW_BOUND_LOTTO_NUMBER || number > UPPER_BOUND_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또 범위는 1 ~ 45 범위만 가능합니다.");
        }
        return new LottoNumber(number);
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return getNumber() == that.getNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber());
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
