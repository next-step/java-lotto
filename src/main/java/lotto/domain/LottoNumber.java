package lotto.domain;

import lotto.common.ErrorCode;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        if (lottoNumber < MIN_LOTTO_NUMBER || lottoNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ErrorCode.INVALID_LOTTO_NUMBER_RANGE.getErrorMessage());
        }
        this.lottoNumber = lottoNumber;
    }

    public Integer of() {
        return this.lottoNumber;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.lottoNumber - o.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(lottoNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if ( obj != null && obj.getClass() == this.getClass()) {
            return ((LottoNumber)obj).lottoNumber == this.lottoNumber;
        }
        return super.equals(obj);
    }
}
