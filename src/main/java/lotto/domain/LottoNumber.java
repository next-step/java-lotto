package lotto.domain;

import lotto.exception.InvalidLottoNumberException;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private Integer lottoNumber;

    LottoNumber(Integer lottoNumber) {
        checkRangeOfLottoNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    void checkRangeOfLottoNumber(int lottoNumber) {
        if (checkNumberRange(lottoNumber, LottoFactory.MIN_LOTTO_NUMBER, LottoFactory.MAX_LOTTO_NUMBER)) {
            throw new InvalidLottoNumberException(lottoNumber);
        }
    }

    private boolean checkNumberRange(int lottoNumber, int minNumber, int maxNumber) {
        return (lottoNumber < minNumber) || (lottoNumber > maxNumber);
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        return this.lottoNumber.compareTo(lottoNumber.getLottoNumber());
    }

    public Integer getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(lottoNumber, that.lottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public String toString() {
        return lottoNumber.toString();
    }
}
