package domain;

import exception.InvalidRangeNumberException;

import java.util.Objects;

public class LottoNumber {
    public static final int MIN_NUMBER_BOUND = 1;
    public static final int MAX_NUMBER_BOUND = 45;

    public int lottoNumber;

    private LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber valueOf(int lottoNumber) {
        validate(lottoNumber);
        return new LottoNumber(lottoNumber);
    }

    private static void validate(int lottoNumber) {
        if (lottoNumber < MIN_NUMBER_BOUND || lottoNumber > MAX_NUMBER_BOUND) {
            throw new InvalidRangeNumberException();
        }
    }

    public int getValue() {
        return lottoNumber;
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
}
