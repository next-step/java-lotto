package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LottoShop {
    private final static int LOTTO_PRICE = 1000;

    private final LottoNumberStrategy lottoNumberStrategy;
    private final Money payed;
    private final int manualPurchaseCount;
    private final List<Lotto> lottos = new ArrayList<>();

    public LottoShop(LottoNumberStrategy lottoNumberStrategy, final Money payed, final int manualPurchaseCount) {
        this.payed = payed;
        this.lottoNumberStrategy = lottoNumberStrategy;
        this.manualPurchaseCount = manualPurchaseCount;
    }

    public Lottos buy() {
        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < payed.calculateQuantity(LOTTO_PRICE); i++) {
            result.add(Lotto.create(lottoNumberStrategy));
        }
        return new Lottos(result);
    }

    public int numberOfPurchasingAuto() {
        return payed.calculateQuantity(LOTTO_PRICE) - manualPurchaseCount;
    }
}
