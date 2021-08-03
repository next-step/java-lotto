package lotto.domain;

import lotto.exception.LottoNumberRangeException;

import java.util.Objects;

public class LottoNumber {
    private static final int MIN_LOTTO_NUMBER  = 1;
    private static final int MAX_LOTTO_NUMBER  = 45;

    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validate(lottoNumber);
        this.lottoNumber = lottoNumber;
    }
    public static LottoNumber of(int lottoNumber) {
        return new LottoNumber(lottoNumber);
    }

    private void validate(int lottoNumber) {
        if(lottoNumber < MIN_LOTTO_NUMBER || lottoNumber > MAX_LOTTO_NUMBER){
            throw new LottoNumberRangeException();
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
