package lotto.domain;

public class WinningLotto {

    private final Lotto lastWeakLotto;

    public WinningLotto(Lotto lastWeakLotto) {
        this.lastWeakLotto = lastWeakLotto;
    }

    public static WinningLotto from(Lotto lotto) {
        return new WinningLotto(lotto);
    }

    public int compare(Lotto lotto) {
        return lastWeakLotto.matchCount(lotto);
    }

}
