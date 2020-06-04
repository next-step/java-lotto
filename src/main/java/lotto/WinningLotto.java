package lotto;

public class WinningLotto {
    private final Lotto lotto;

    public WinningLotto(Lotto lotto) {
        this.lotto = lotto;
    }

    public Rank match(Lotto userLotto) {
        int countOfMatch = lotto.match(userLotto);
        return Rank.valueOf(countOfMatch);
    }
}
