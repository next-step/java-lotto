package study.ascii92der.lotto.step3n4;

public class LottoResult {

    private LottoWinner lottoWinner;

    public LottoResult(Lotto lotto, WinningLotto winningLotto) {
        this.lottoWinner = LottoWinner.valueOf(winningLotto.match(lotto), winningLotto.isMatchedBonus(lotto));
    }

    public LottoWinner result() {
        return lottoWinner;
    }
}
