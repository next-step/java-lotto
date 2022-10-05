package lotto.domain;

import lotto.controller.LottoFactory;

public class LottoStore {
    public static final Money LOTTO_PRICE = Money.of(1000);

    private final LottoFactory lottoFactory;

    public LottoStore(LottoFactory lottoFactory) {
        this.lottoFactory = lottoFactory;
    }

    public Lottos sell(Money purchaseAmount, Lottos manualLottos) {
        Integer purchaseCount = purchaseAmount.divide(LOTTO_PRICE);

        Lottos autoLottos = new Lottos(lottoFactory, purchaseCount - manualLottos.count());

        return manualLottos.add(autoLottos);
    }
}
