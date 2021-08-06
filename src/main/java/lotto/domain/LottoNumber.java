package lotto.domain;

import lotto.exception.WrongLottoNumberException;

public class LottoNumber {

    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;
    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateLottoNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validateLottoNumber(int lottoNumber) {
        if (lottoNumber < MIN_NUMBER || lottoNumber > MAX_NUMBER) {
            throw new WrongLottoNumberException(String.format("'%d'는 유효한 번호가 아닙니다.", lottoNumber));
        }

    }
}
