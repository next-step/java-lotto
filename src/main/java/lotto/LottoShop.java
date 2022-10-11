package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {
    private final static int LOTTO_PRICE = 1000;

    public Lottos buy(final Money money) {
        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < money.calculateQuantity(LOTTO_PRICE); i++) {
            result.add(Lotto.print());
        }
        return new Lottos(result);
    }
}
