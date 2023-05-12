package lotto.domain;

public class WinningLotto {
    private final Lotto winningLotto;
    private final LottoNumber bonus;
    public WinningLotto(Lotto winningLotto, LottoNumber bonus) {
        this.winningLotto = winningLotto;
        this.bonus = bonus;
    }

    public Rank findRank(Lotto lotto) {
        return Rank.of(winningLotto.countMatching(lotto), hasBonus(lotto));
    }

    private boolean hasBonus(Lotto lotto) {
        return lotto.contains(bonus);
    }
}
