package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {
    private final static int LOTTO_PRICE = 1000;

    private final LottoNumberStrategy lottoNumberStrategy;

    public LottoShop(LottoNumberStrategy lottoNumberStrategy) {
        this.lottoNumberStrategy = lottoNumberStrategy;
    }

    public Lottos buy(final Money money) {
        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < money.calculateQuantity(LOTTO_PRICE); i++) {
            result.add(Lotto.create(lottoNumberStrategy));
        }
        return new Lottos(result);
    }
}
