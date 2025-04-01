package lotto;

public class WinningLotto {
    private Lotto winningLotto;
    private LottoNumber bonusNumber;

    public WinningLotto(Lotto winningLotto, LottoNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public LottoRank getRank(Lotto lotto) {
        return LottoRank.valueOf(lotto.getMatchCount(winningLotto), lotto.isMatchedBonus(bonusNumber));
    }

}
