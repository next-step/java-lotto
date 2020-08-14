package lotto.domain;

public class LottoGame {

    private final Lotto winningLotto;
    private final LottoNumber bonusBall;

    public LottoGame(Lotto winningLotto, LottoNumber bonusBall) {
        this.winningLotto = winningLotto;
        this.bonusBall = bonusBall;
    }

    public LottoResult match(Lottos lottos) {
        LottoResult lottoResult = new LottoResult(getPurchasePrice(lottos));
        for (Lotto lotto : lottos) {
            int countOfMatch = winningLotto.countOfMatch(lotto);
            lottoResult.addRanking(LottoRanking.valueOf(countOfMatch, () -> lotto.contain(bonusBall)));
        }
        return lottoResult;
    }

    private int getPurchasePrice(Lottos lottos) {
        return lottos.size() * LottoShop.DEFAULT_PRICE_UNIT;
    }

}
