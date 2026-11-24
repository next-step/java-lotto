package lotto.domain;

public class WinningLotto {

    private final Lotto lotto;

    public WinningLotto(Lotto lotto) {
        this.lotto = lotto;
    }

    public Rank match(Lotto other) {
        return Rank.from(lotto.countMatches(other));
    }
}
