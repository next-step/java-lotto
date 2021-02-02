package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final int LOWER_BOUND_LOTTO = 1;
    private static final int UPPER_BOUND_LOTTO = 46;
    private final int lottoNumber;

    public LottoNumber(final int lottoNumber) {
        checkIsValid(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public int getLottoNumber() {
        return this.lottoNumber;
    }

    private void checkIsValid(int lottoNumber) {
        if (lottoNumber < LOWER_BOUND_LOTTO || lottoNumber > UPPER_BOUND_LOTTO) {
            throw new IllegalArgumentException("로또 숫자의 유효 범위가 아닙니다.");
        }
    }

    @Override
    public int compareTo(LottoNumber lottoObject) {
        if (this.lottoNumber > lottoObject.getLottoNumber()) {
            return 1;
        } else if (this.lottoNumber == lottoObject.getLottoNumber()) {
            if (this.lottoNumber < lottoObject.getLottoNumber()) {
                return 1;
            }
        }
        return -1;
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
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
