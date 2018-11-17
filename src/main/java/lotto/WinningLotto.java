package lotto;

public class WinningLotto {
    private Lotto winningLotto;
    private int bonus;

    public WinningLotto(Lotto winningLotto, int bonus) {
        this.winningLotto = winningLotto;
        this.bonus = bonus;
    }

    int matchLottoCount(Lotto lotto) {
        return winningLotto.match(lotto);
    }

    Rank getRankByMatchingLotto(Lotto lotto) {
        int matchCount = winningLotto.match(lotto);
        boolean matchBonus = lotto.contains(bonus);
        return Rank.valueOf(matchCount, matchBonus);
    }
}
