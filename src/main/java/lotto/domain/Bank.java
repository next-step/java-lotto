package lotto.domain;

public final class Bank {
    private final Lotto answerLotto;
    
    public Bank(Lotto answerLotto) {
        this.answerLotto = answerLotto;
    }

    public LottoWallet matchLottos(Lottos lottos, Money money) {
        LottoWallet lottoWallet = new LottoWallet(money);
        for (Lotto lotto : lottos.getLottos()) {
            lottoWallet.addLottoResult(matchLotto(lotto));
        }
        return lottoWallet;
    }

    private LottoResult matchLotto(Lotto unidentifiedLotto) {
        return LottoResult.findByMatchCount(answerLotto.matchCount(unidentifiedLotto));
    }
}
