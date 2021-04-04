package lotto.domain;

import lotto.constant.LottoConstant;
import lotto.constant.LottoError;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        if (LottoConstant.LOTTO_FIRST_NUMBER > lottoNumber || lottoNumber > LottoConstant.LOTTO_LAST_NUMBER) {
            throw new IllegalArgumentException(LottoError.LOTTO_NUMBER_OVER_EXCEPTION);
        }
        this.lottoNumber = lottoNumber;
    }

    public boolean isMatchBonus(LottoNumber bonusNumber) {
        return this.lottoNumber == bonusNumber.lottoNumber;
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

    @Override
    public int compareTo(LottoNumber other) {
        return Integer.compare(this.lottoNumber, other.lottoNumber);
    }
}
