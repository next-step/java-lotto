package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {

    private static final int PRICE_PER_LOTTO = 1000;

    public Lottos purchase(int purchaseMoney) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseMoney / PRICE_PER_LOTTO; i++) {
            lottos.add(new Lotto());
        }

        return new Lottos(lottos);
    }
}
