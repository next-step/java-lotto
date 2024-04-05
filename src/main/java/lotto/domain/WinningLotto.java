package lotto.domain;

public class WinningLotto {
    private Lotto winningNumber;
    private LottoNumber bonusNumber;

    public WinningLotto(Lotto winningNumber, LottoNumber bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public LottoRank findRank(Lotto lotto) {
        return LottoRank.of(lotto.getMatchNumberCount(this.winningNumber), lotto.hasNumber(this.bonusNumber));
    }

}
