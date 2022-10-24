package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {
    private final static int LOTTO_PRICE = 1000;
    private final LottoNumberStrategy lottoNumberStrategy;

    private final Money payed;

    public LottoShop(LottoNumberStrategy lottoNumberStrategy, final Money payed) {
        this.payed = payed;
        this.lottoNumberStrategy = lottoNumberStrategy;
    }

    public Lottos buy() {
        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < payed.calculateQuantity(LOTTO_PRICE); i++) {
            result.add(Lotto.create(lottoNumberStrategy));
        }
        return new Lottos(result);
    }
}
