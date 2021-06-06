package lotto.model;

import java.util.Objects;

public class LottoNumber {
    private static final int MAX_LOTTO_NUMBER_VALUE = 45;
    private static final int MINIMUM_LOTTO_NUMBER_VALUE = 1;
    private static final String NOT_VALIDATE_NUMBER_RANGE_MESSAGE = "로또번호는 1~45 사이의 숫자입니다.";

    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validate(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validate(int lottoNumber) {
        if (lottoNumber < MINIMUM_LOTTO_NUMBER_VALUE || lottoNumber > MAX_LOTTO_NUMBER_VALUE) {
            throw new IllegalArgumentException(NOT_VALIDATE_NUMBER_RANGE_MESSAGE);

        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public String toString() {
        return Integer.toString(lottoNumber);
    }
}
