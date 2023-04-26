package step2.domain;

import step2.domain.strategy.Strategy;

public class LottoStoreService {

    public LottoStoreService() {
    }

    public static LottoStoreService createLottoStoreService() {
        return new LottoStoreService();
    }

    public int getLotto(Strategy strategy, int purchaseAmount) {
        return strategy.buyLotto(purchaseAmount);
    }
}
