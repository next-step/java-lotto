package step4.domain.lotto;

import step4.exception.LottoNumberOutOfRangeException;

public final class LottoNumber {

    private static final int MINIMUM = 1;
    private static final int MAXIMUM = 45;

    private final int lottoNumber;

    private LottoNumber(int lottoNumber) {
        validateRange(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public final static LottoNumber valueOf(int lottoNumber) {
        return new LottoNumber(lottoNumber);
    }

    private final void validateRange(int lottoNumber) {
        if (lottoNumber < MINIMUM || lottoNumber > MAXIMUM) {
            throw new LottoNumberOutOfRangeException();
        }
    }

}
