package lotto.domain;

public class LottoGame {

    private final Lotto winningLotto;
    private final LottoNumber bonusBall;

    public LottoGame(Lotto winningLotto, LottoNumber bonusBall) {
        this.winningLotto = winningLotto;
        this.bonusBall = bonusBall;
    }

    public LottoResult match(Lottos lottos) {
        LottoResult lottoResult = new LottoResult(lottos.getTotalPrice());
        lottos.matchWinningLotto(winningLotto, bonusBall, lottoResult::addRanking);
        return lottoResult;
    }

}
