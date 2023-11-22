package lotto.domain;

public class WinningLotto {

    private final Lotto lastWeakLotto;

    private final LottoNumber bonusBall;

    public WinningLotto(Lotto lastWeakLotto, LottoNumber bonusBall) {
        this.lastWeakLotto = lastWeakLotto;
        this.bonusBall = bonusBall;
    }

    public static WinningLotto of(Lotto lotto, LottoNumber bonusBall) {
        return new WinningLotto(lotto, bonusBall);
    }

    public int compare(Lotto lotto) {
        int matchCount = lastWeakLotto.matchCount(lotto);
        matchCount += matchBonusBall(lotto);
        return matchCount;
    }

    private int matchBonusBall(Lotto lotto) {
        if (lotto.contains(this.bonusBall)) {
            return 1;
        }
        return 0;
    }

}
