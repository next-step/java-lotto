package lotto.domain;

public class WinningLotto {

    private final Lotto winningLotto;

    public WinningLotto(Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public LottoRanking matching(Lotto lotto) {
        return LottoRanking.valueOf(winningLotto.countOfMatch(lotto));
    }
}
