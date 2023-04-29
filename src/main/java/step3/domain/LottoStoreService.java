package step3.domain;

import step3.domain.strategy.price.PriceStrategy;

public class LottoStoreService {
    private LottoStoreService() {
        // 생성자 내부 호출 -> 명시적 Exception
        throw new AssertionError();
    }

    public static int getLottoCount(PriceStrategy strategy, int purchaseAmount) {
        return strategy.buyLotto(purchaseAmount);
    }
}
