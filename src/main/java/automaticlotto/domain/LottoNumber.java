package automaticlotto.domain;

import automaticlotto.automaticexception.ExceptionCommand;
import automaticlotto.automaticexception.InputValueException;

public class LottoNumber {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateLottoNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validateLottoNumber(int lottoNumber) {
        if (lottoNumber < MIN_LOTTO_NUMBER || lottoNumber > MAX_LOTTO_NUMBER) {
            throw new InputValueException(ExceptionCommand.LOTTO_NUMBER_RANGE_EXCEPTION_MESSAGE);
        }
    }

    public int getLottoNumber() {
        return this.lottoNumber;
    }
}
