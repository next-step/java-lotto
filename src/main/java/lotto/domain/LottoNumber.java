package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final int FIRST_RANGE_LOTTO_NUMBER = 0;
    private static final int END_RANGE_LOTTO_NUMBER = 46;
    private final Integer lottoNumber;

    public LottoNumber() {
        lottoNumber = null;
    }

    public LottoNumber(Integer lottoNumber) throws IllegalArgumentException {
        try {
            validateLottoNumber(lottoNumber);
            this.lottoNumber = lottoNumber;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public LottoNumber getLottoNumber() {
        return new LottoNumber(lottoNumber);
    }

    private void validateLottoNumber(Integer lottoNumber) throws IllegalArgumentException {
        if (!checkLottoNumber(lottoNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean checkLottoNumber(Integer lottoNumber) {
        return FIRST_RANGE_LOTTO_NUMBER < lottoNumber && lottoNumber < END_RANGE_LOTTO_NUMBER;
    }

    @Override
    public String toString() {
        return lottoNumber.toString();
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        if (this.lottoNumber < lottoNumber.lottoNumber) {
            return -1;
        }
        if (this.lottoNumber == lottoNumber.lottoNumber) {
            return 0;
        }
        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(lottoNumber, that.lottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
