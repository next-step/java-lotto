package lotto.domain;

import lotto.controller.LottoFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LottoStore {
    static final BigDecimal LOTTO_PRICE = BigDecimal.valueOf(1000L);

    private final LottoFactory lottoFactory;

    public LottoStore(LottoFactory lottoFactory) {
        this.lottoFactory = lottoFactory;
    }

    public Lottos sell(Integer purchaseAmount, Lottos manualLottos) {
        int purchaseCount = BigDecimal.valueOf(purchaseAmount)
                .divide(LOTTO_PRICE, 0, RoundingMode.FLOOR)
                .intValue();

        Lottos autoLottos = new Lottos(lottoFactory, purchaseCount - manualLottos.count());

        return manualLottos.add(autoLottos);
    }
}
