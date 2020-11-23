package step4.domain;

import step4.exception.LottoNumberRangeException;

import java.util.Objects;

public class LottoNumber {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;

    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        valid(lottoNumber);

        this.lottoNumber = lottoNumber;
    }

    private void valid(int lottoNumber) {
        if(!findRange(lottoNumber)){
            throw new LottoNumberRangeException();
        }
    }

    private boolean findRange(int lottoNumber) {
        return lottoNumber <= MAX_LOTTO_NUMBER && lottoNumber >= MIN_LOTTO_NUMBER;
    }

    public int getLottoNumber() {
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
