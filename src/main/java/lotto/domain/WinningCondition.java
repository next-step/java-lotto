package lotto.domain;

public class WinningCondition {
    private final Lotto winningLotto;
    private final LottoNo bonus;

    public WinningCondition(Lotto winningLotto, LottoNo bonus) {
        this.winningLotto = winningLotto;
        this.bonus = bonus;
    }

    Rank getRank(Lotto lotto) {
        return Rank.valueOf(
                lotto.getCountOfMatch(winningLotto)
                , lotto.contains(bonus)
        );
    }
}
