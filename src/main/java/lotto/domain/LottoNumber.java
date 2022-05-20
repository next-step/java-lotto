package lotto.domain;

import java.util.Objects;

public class LottoNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final String INVALID_NUMBER = "숫자는 " + MIN_NUMBER + " ~ " + MAX_NUMBER + " 까지의 숫자만 가능합니다. 현재 숫자 : %d";

    private final IntNumber number;

    public LottoNumber(int number) {
        this(new IntNumber(number));
    }
    public LottoNumber(IntNumber intNumber) {
        if (intNumber.getNumber() > MAX_NUMBER || intNumber.getNumber() < MIN_NUMBER) {
            throw new IllegalArgumentException(String.format(INVALID_NUMBER, intNumber.getNumber()));
        }

        this.number = intNumber;
    }

    public IntNumber getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number.getNumber() == that.number.getNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(number.getNumber());
    }

    @Override
    public String toString() {
        return String.valueOf(number.getNumber());
    }
}
