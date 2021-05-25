package lotto.domain;

import lotto.common.ErrorCode;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    private final int LOTTO_NUMBER;

    public LottoNumber(int lottoNumber) {
        if (lottoNumber < MIN_LOTTO_NUMBER || lottoNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ErrorCode.INVALID_LOTTO_NUMBER_RANGE.getErrorMessage());
        }
        this.LOTTO_NUMBER = lottoNumber;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.LOTTO_NUMBER - o.LOTTO_NUMBER;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(LOTTO_NUMBER);
    }

    @Override
    public boolean equals(Object obj) {
        if ( obj != null && obj.getClass() == this.getClass()) {
            return ((LottoNumber)obj).LOTTO_NUMBER == this.LOTTO_NUMBER;
        }
        return super.equals(obj);
    }

    public Integer of() {
        return this.LOTTO_NUMBER;
    }
}
