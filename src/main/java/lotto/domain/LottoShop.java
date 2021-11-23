package lotto.domain;

import java.util.List;

public class LottoShop {

    public static final int LOTTO_PRICE = 1000;

    private final LottoCashier lottoCashier = new LottoCashier();

    public List<Lotto> buyLottos(int money) {
        return lottoCashier.pay(money);
    }

    public LottoResult match(List<Lotto> lottos, Lotto winLotto) {
        LottoCounter lottoCounter = new LottoCounter();
        for (Lotto lotto : lottos) {
            lottoCounter.countResult(lotto.countMatch(winLotto));
        }
        return lottoCounter.makeResult();
    }

}
