package lotto.domain;

/**
 * 지난주 당첨번호를 알고있고 구매한 로또들이 몇등에 당첨되었는지 알려주는 객체
 */
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
