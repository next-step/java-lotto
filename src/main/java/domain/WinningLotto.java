package domain;

import domain.wrapper.LottoNo;

public class WinningLotto {
    private LottoNo bonusNumber;
    private Lotto lotto;

    public WinningLotto(Lotto lotto, LottoNo bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public LottoResult getCombineNumbers(Lotto lotto) {
        return new LottoResult(this.lotto.getCombineCount(lotto),  lotto.isContains(bonusNumber));
    }

    public int getCombineCount(Lotto lastLotto) {
        return lotto.getCombineCount(lastLotto);
    }
}
