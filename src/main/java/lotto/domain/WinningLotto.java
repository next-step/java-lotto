package lotto.domain;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNo bonusNumber;

    public WinningLotto(Lotto lotto, LottoNo bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Rank calculateRank(Lotto lotto) {
        return Rank.valueOf(this.lotto.matchCount(lotto), lotto.isMatch(bonusNumber));
    }
}
