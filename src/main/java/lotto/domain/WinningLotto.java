package lotto.domain;

public class WinningLotto {
    private Lotto winningNumber;
    private int bonusNumber;

    public WinningLotto(Lotto winningNumber, int bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public LottoRank findRank(Lotto lotto) {
        return LottoRank.find(lotto.getMatchNumberCount(this.winningNumber), lotto.hasNumber(this.bonusNumber));
    }

}
