package lotto.domain;

import java.util.Set;
import java.util.function.Supplier;

public class LottoManualSalesStoreBuilder {
    private final LottoPurchase lottoPurchase;

    public LottoManualSalesStoreBuilder(LottoPurchase lottoPurchase) {
        this.lottoPurchase = lottoPurchase;
    }

    static LottoManualSalesStoreBuilder createManualLottos(LottoPurchase lottoPurchase) {
        return new LottoManualSalesStoreBuilder(lottoPurchase);
    }

    public LottoStore createManualLottoStore(Supplier<Set<Integer>> manualLotto) {
        ImmutableLotteries lottos = ImmutableLotteries.builder()
                                                      .manualLotto(lottoPurchase.getManualLottoCount(), manualLotto)
                                                      .autoLottos(lottoPurchase.getAutoLottoGeneratedCount())
                                                      .build();
        return new LottoStore(lottoPurchase, lottos);
    }
}
