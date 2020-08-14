package lotto.domain;

public class LottoGame {

    private final Lotto winningLotto;
    private final LottoNumber bonusBall;
    private final int purchasePrice;

    public LottoGame(Lotto winningLotto, LottoNumber bonusBall, int purchasePrice) {
        this.winningLotto = winningLotto;
        this.bonusBall = bonusBall;
        this.purchasePrice = purchasePrice;
    }

    public LottoResult match(Lottos lottos) {
        LottoResult lottoResult = new LottoResult(purchasePrice);
        for (Lotto lotto : lottos) {
            int countOfMatch = winningLotto.countOfMatch(lotto);
            lottoResult.addRanking(LottoRanking.valueOf(countOfMatch, () -> lotto.contain(bonusBall)));
        }
        return lottoResult;
    }

}
