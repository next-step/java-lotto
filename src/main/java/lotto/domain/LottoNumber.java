package lotto.domain;

import lotto.LottoConfig;

import java.util.Comparator;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateLottoNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    private void validateLottoNumber(int lottoNumber) {
        if (lottoNumber < LottoConfig.LOTTO_START_NUMBER || lottoNumber > LottoConfig.LOTTO_LAST_NUMBER) {
            throw new IllegalArgumentException(LottoConfig.LOTTO_NUMBER_ERROR_MESSAGE);
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
    public int compareTo(LottoNumber o) {
        return this.lottoNumber - o.lottoNumber;
    }
}
