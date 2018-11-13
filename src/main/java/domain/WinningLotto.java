package domain;

public class WinningLotto {
    private Integer bonusNumber;
    private Lotto lotto;

    public WinningLotto(Lotto lotto, Integer bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public WinningLotto(Lotto lotto) {
        this.lotto = lotto;
    }

    public LottoResult getCombineNumbers(Lotto lotto) {
        return new LottoResult(this.lotto.getCombineCount(lotto), lotto.isContains(bonusNumber));
    }

    public int getCombineCount(Lotto lastLotto) {
        return lotto.getCombineCount(lastLotto);
    }
}
