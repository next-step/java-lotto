package step3.domain.lotto;

import step3.exception.LottoNumberOutOfRangeException;

public final class LottoNumber {

    private static final int MINIMUM = 1;
    private static final int MAXIMUM = 45;

    private final int lottoNumber;

    private LottoNumber(int lottoNumber) {
        validateNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public static final LottoNumber valueOf(int lottoNumber) {
        return new LottoNumber(lottoNumber);
    }

    private final void validateNumber(int lottoNumber) {
        if (lottoNumber < MINIMUM || MAXIMUM < lottoNumber) {
            throw new LottoNumberOutOfRangeException();
        }
    }

}
