package lotto.model;

import lotto.strategy.AutoLottoStrategy;
import lotto.strategy.LottoRuleStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoShop {
    private static final LottoRuleStrategy LOTTO_STRATEGY = AutoLottoStrategy.getInstance();

    public static final int LOTTO_PRICE = 1_000;

    private static LottoShop lottoShop;

    private LottoShop() {
    }

    public static synchronized LottoShop getInstance() {
        if (Objects.isNull(lottoShop)) {
            lottoShop = new LottoShop();
        }
        return lottoShop;
    }

    public Lottos buy(final int payment) {
        validate(payment);

        int numberOfPurchases = payment / LOTTO_PRICE;

        List<Lotto> lottos = new ArrayList<>();
        while (0 < numberOfPurchases--) {
            lottos.add(LOTTO_STRATEGY.ticketing());
        }

        return Lottos.from(lottos);
    }

    private void validate(final int payment) {
        if (payment < LOTTO_PRICE) {
            throw new IllegalArgumentException("don't have enough money.");
        }
    }
}
