package rankingtwolotto.domain;

import rankingtwolotto.rankingexception.ExceptionCommand;
import rankingtwolotto.rankingexception.RankingValueException;

public class LottoNumber {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    private int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateLottoNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validateLottoNumber(int lottoNumber) {
        if (lottoNumber < LOTTO_MIN_NUMBER || lottoNumber > LOTTO_MAX_NUMBER) {
            throw new RankingValueException(ExceptionCommand.LOTTO_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

}
