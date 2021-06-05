package study.ascii92der.lotto.step3to5;

public class LottoResult {

    private LottoWinner lottoWinner;

    public LottoResult(Lotto lotto, WinningLotto winningLotto) {
        this.lottoWinner = LottoWinner.valueOf(winningLotto.match(lotto), winningLotto.isMatchedBonus(lotto));
    }

    public LottoWinner result() {
        return lottoWinner;
    }
}
