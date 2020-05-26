package lotto.domain.number;

import lotto.exception.ErrorMessage;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;

    private final int number;

    private LottoNumber(final int number) {
        verifyRange(number);
        this.number = number;
    }

    public static LottoNumber of(final int number) {
        return new LottoNumber(number);
    }

    private void verifyRange(final int number) {
        if (MAX_VALUE < number || MIN_VALUE > number) {
            throw new IllegalArgumentException(String.format(ErrorMessage.RANGE_OF_LOTTO_NUMBER, MIN_VALUE, MAX_VALUE));
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumber)) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(final LottoNumber lottoNumber) {
        return this.number - lottoNumber.number;
    }
}
