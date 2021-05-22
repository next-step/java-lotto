package step2.model;

public class LottoWinning {

    private final Lotto winningLotto;

    private LottoWinning(Lotto lotto) {
        this.winningLotto = lotto;
    }

    public static LottoWinning of(Lotto winningNumber) {
        return new LottoWinning(winningNumber);
    }

    public LottoRank getRankOfLotto(Lotto lotto) {
        long same = winningLotto.checkWinningCount(lotto);
        return LottoRank.valueOf(same);
    }
}