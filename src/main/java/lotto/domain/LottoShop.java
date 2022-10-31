package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {
    private final LottoNumberStrategy lottoNumberStrategy;

    public LottoShop(LottoNumberStrategy lottoNumberStrategy) {
        this.lottoNumberStrategy = lottoNumberStrategy;
    }

    public Lottos buy(final Money money) {
        List<Lotto> lottos = new ArrayList<>();
        int quantity = money.calculateMaxQuantity();
        for (int i = 0; i < quantity; i++) {
            lottos.add(Lotto.create(lottoNumberStrategy));
        }
        return new Lottos(lottos);
    }
}
