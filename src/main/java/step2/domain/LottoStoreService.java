package step2.domain;

import step2.domain.strategy.price.Strategy;

public class LottoStoreService {

    public static LottoStoreService createLottoStoreService() {
        return new LottoStoreService();
    }

    public int getLottoCount(Strategy strategy, int purchaseAmount) {
        return strategy.buyLotto(purchaseAmount);
    }
}
