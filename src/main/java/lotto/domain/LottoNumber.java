package lotto.domain;

import lotto.domain.exception.InvalidLottoNumberException;
import lotto.domain.exception.InvalidLottoParsingNumberException;

import java.util.Objects;

public class LottoNumber {
    public static final int MINIMUM_LOTTO_NUMBER = 1;
    public static final int MAXIMUM_LOTTO_NUMBER = 45;

    private final int number;

    public LottoNumber(int number) {
        if (!isBetweenMinAndMax(number)) {
            throw new InvalidLottoNumberException(
                    "입력한 숫자 : ",
                    String.valueOf(number)
            );
        }

        this.number = number;
    }

    private boolean isBetweenMinAndMax(int number) {
        return number >= MINIMUM_LOTTO_NUMBER &&
                number <= MAXIMUM_LOTTO_NUMBER;
    }

    public int getNumber() {
        return number;
    }

    public static LottoNumber from(String input) {
        try {
            return new LottoNumber(Integer.parseInt(input));
        } catch (NumberFormatException exception) {
            throw new InvalidLottoParsingNumberException(
                    exception,
                    "입력한 문자열 : ",
                    input
            );
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (o instanceof Integer) return number == (Integer) o;
        if (getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
