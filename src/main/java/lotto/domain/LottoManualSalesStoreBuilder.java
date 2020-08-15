package lotto.domain;

import java.util.Set;
import java.util.function.Supplier;

public class LottoManualSalesStoreBuilder {
    private final LottoPurchase lottoPurchase;
    private ImmutableLotteries lottos;

    LottoManualSalesStoreBuilder(LottoPurchase lottoPurchase) {
        this.lottoPurchase = lottoPurchase;
    }

    static LottoManualSalesStoreBuilder createManualLottos(LottoPurchase lottoPurchase) {
        return new LottoManualSalesStoreBuilder(lottoPurchase);
    }

    public LottoManualSalesStoreBuilder forEachBuyerInputManualLotto(Supplier<Set<Integer>> manualLotto) {
        lottos = ImmutableLotteries.builder()
                                   .manualLotto(lottoPurchase.getManualLottoCount(), manualLotto)
                                   .autoLottos(lottoPurchase.getAutoLottoGeneratedCount())
                                   .build()
        ;
        return this;
    }

    public LottoStore createLottoStore() {
        return new LottoStore(lottoPurchase, lottos);
    }
}
