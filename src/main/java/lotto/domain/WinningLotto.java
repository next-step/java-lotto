package lotto.domain;

public class WinningLotto {
    private Lotto winningLotto;
    private LottoNo bonus;

    public WinningLotto(Lotto winningLotto, LottoNo bonus) {
        this.winningLotto = winningLotto;
        this.bonus = bonus;
    }

    int matchLottoCount(Lotto lotto) {
        return winningLotto.match(lotto);
    }

    public Rank getRankByMatchingLotto(Lotto lotto) {
        int matchCount = winningLotto.match(lotto);
        boolean matchBonus = lotto.contains(bonus);
        return Rank.valueOf(matchCount, matchBonus);
    }
}
