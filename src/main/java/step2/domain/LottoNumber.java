package step2.domain;

import step2.exception.IllegalLottoNumberException;

public class LottoNumber {
    public static final int LOTTO_NUMBER_RANGE_MIN = 1;
    public static final int LOTTO_NUMBER_RANGE_MAX = 45;

    private final Integer lottoNumber;

    public LottoNumber(Integer lottoNumber) {
        if (lottoNumber == null
                || lottoNumber < LOTTO_NUMBER_RANGE_MIN
                || lottoNumber > LOTTO_NUMBER_RANGE_MAX)
            throw new IllegalLottoNumberException("1 ~ 45 이내의 숫자만 입력할수 있습니다");

        this.lottoNumber = lottoNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumber)) return false;

        LottoNumber that = (LottoNumber) o;

        return lottoNumber != null ? lottoNumber.equals(that.lottoNumber) : that.lottoNumber == null;
    }

    @Override
    public int hashCode() {
        return lottoNumber != null ? lottoNumber.hashCode() : 0;
    }

    @Override
    public String toString() {
        return lottoNumber.toString();
    }
}
