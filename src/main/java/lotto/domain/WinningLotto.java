package lotto.domain;

public class WinningLotto {

    private final Lotto winningLotto;
    private final LottoNumber bonusBall;

    public WinningLotto(Lotto winningLotto, LottoNumber bonusBall) {
        this.winningLotto = winningLotto;
        this.bonusBall = bonusBall;
    }

    public LottoRanking match(Lotto lotto) {
        int countOfMatch = winningLotto.countOfMatch(lotto);
        return LottoRanking.valueOf(countOfMatch, () -> lotto.contain(bonusBall));
    }
}
