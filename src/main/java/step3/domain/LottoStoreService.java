package step3.domain;

import step3.domain.strategy.price.PriceStrategy;

import java.util.Objects;

public class LottoStoreService {
    // singleton 적용
    private static LottoStoreService lottoStoreService = null;

    public static LottoStoreService createLottoStoreService() {
        if (Objects.isNull(lottoStoreService)) {
            return new LottoStoreService();
        }
        return lottoStoreService;
    }

    public int getAutoLottoCount(PriceStrategy strategy, int purchaseAmount) {
        return strategy.buyLotto(purchaseAmount);
    }

    public int getRemainingMoneyAfterBuyLotto(PriceStrategy strategy, int purchaseAmount, int manualLottoCount) {
        return strategy.buyManualLotto(purchaseAmount, manualLottoCount);
    }
}
