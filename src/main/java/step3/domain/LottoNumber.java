package step3.domain;

import step3.common.ErrorCode;

public class LottoNumber {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        if (lottoNumber < MIN_LOTTO_NUMBER || lottoNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ErrorCode.INVALID_LOTTO_NUMBER_RANGE.getErrorMessage());
        }
        this.lottoNumber = lottoNumber;
    }
}
