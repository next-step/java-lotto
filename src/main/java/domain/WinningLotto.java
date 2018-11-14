package domain;

import domain.wrapper.LottoNo;

public class WinningLotto {
//    private Integer bonusNumber;
    private LottoNo bonusNumber;
    private Lotto lotto;

    public WinningLotto(Lotto lotto, LottoNo bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public WinningLotto(Lotto lotto) {
        this.lotto = lotto;
    }

//    public WinningLotto(Lotto lotto, Integer bonusNumber) {
//        this.lotto = lotto;
//        this.bonusNumber = bonusNumber;
//    }

    public LottoResult getCombineNumbers(Lotto lotto) {
        return new LottoResult(this.lotto.getCombineCount(lotto),  lotto.isContains(bonusNumber.getNumber()));
    }

//    public LottoResult getCombineNumbers(Lotto lotto) {
//        return new LottoResult(this.lotto.getCombineCount(lotto),  lotto.isContains(bonusNumber.getNumber()));
//    }

    public int getCombineCount(Lotto lastLotto) {
        return lotto.getCombineCount(lastLotto);
    }
}
