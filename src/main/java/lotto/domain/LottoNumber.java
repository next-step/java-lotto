package lotto.domain;

import lotto.common.ErrorMessage;

public class LottoNumber {
    private final static int MIN_NUMBER = 1;
    private final static int MAX_NUMBER = 45;
    private int lottoNumber;
    
    public LottoNumber(int lottoNumber) {
        if (lottoNumber < MIN_NUMBER || lottoNumber < MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE_ERROR.message());
        }
        this.lottoNumber = lottoNumber;
    }
}
