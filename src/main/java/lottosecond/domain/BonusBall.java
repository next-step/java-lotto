package lottosecond.domain;

import lottosecond.domain.lotto.Lotto;
import lottosecond.domain.lotto.LottoNumber;

public class BonusBall {

    private final LottoNumber lottoNumber;

    public BonusBall(int number) {
        this.lottoNumber = LottoNumber.of(number);
    }

    public boolean isDuplicateWithLastWinningLottoNumber(Lotto lotto) {
        return lotto.hasLottoNumber(lottoNumber);
    }

    public LottoNumber getNumber() {
        return lottoNumber;
    }
}
