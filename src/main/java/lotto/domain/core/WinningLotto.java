package lotto.domain.core;

import lotto.domain.LottoWinningAndPrizeMoney;

public class WinningLotto {
    private final Lotto wonLotto;
    private final LottoNo bonusNo;

    WinningLotto(Lotto wonLotto, LottoNo bonusNo) {
        this.wonLotto = wonLotto;
        this.bonusNo = bonusNo;
    }

    public LottoWinningAndPrizeMoney award(Lotto otherLotto){
        return LottoWinningAndPrizeMoney.confirmWin(wonLotto.countOfMatch(otherLotto), otherLotto.contains(bonusNo));
    }
}
