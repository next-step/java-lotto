package lotto.domain;

import java.util.Objects;

import static lotto.domain.LottoOptions.MAX_NUMBER;
import static lotto.domain.LottoOptions.MIN_NUMBER;

/**
 * 로또 번호
 */
public final class LottoNumber implements Comparable<LottoNumber> {
    public static final String LOTTO_NUMBER_NOT_BETWEEN_1_AND_45_MESSAGE = "로또번호는 1-45 사이의 숫자만 가능합니다.";
    private final int number;

    public LottoNumber(final int number) {
        validateNumber(number);
        this.number = number;
    }

    private void validateNumber(final int number) {
        if (number < MIN_NUMBER ||
                number > MAX_NUMBER) {
            throw new IllegalArgumentException(LOTTO_NUMBER_NOT_BETWEEN_1_AND_45_MESSAGE);
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final LottoNumber that = (LottoNumber) o;
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

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
