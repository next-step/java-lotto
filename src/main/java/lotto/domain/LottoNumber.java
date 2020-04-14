package lotto.domain;

import java.util.Objects;

public class LottoNumber {

    private static final String LOTTO_NUMBER_OUT_OF_RANGE_ERROR = "lotto number out of range";

    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;

    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(String number) {
        return of(Integer.parseInt(number.trim()));
    }

    public static LottoNumber of(int number) {
        validateNumber(number);
        return new LottoNumber(number);
    }

    private static void validateNumber(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(LOTTO_NUMBER_OUT_OF_RANGE_ERROR);
        }
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
}
