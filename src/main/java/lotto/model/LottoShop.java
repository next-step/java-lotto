package lotto.model;

import lotto.strategy.AutoLottoStrategy;
import lotto.strategy.LottoRuleStrategy;

import java.util.Objects;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LottoShop {
    private static final LottoRuleStrategy LOTTO_STRATEGY = AutoLottoStrategy.getInstance();

    public static final int LOTTO_PRICE = 1_000;

    private static LottoShop instance;

    private LottoShop() {
    }

    public static synchronized LottoShop getInstance() {
        if (Objects.isNull(instance)) {
            instance = new LottoShop();
        }
        return instance;
    }

    public Lottos buy(final int payment) {
        validate(payment);
        final int numberOfPurchases = payment / LOTTO_PRICE;
        return Lottos.from(Stream.generate(this::getLotto)
                                 .limit(numberOfPurchases)
                                 .collect(toList()));
    }

    private Lotto getLotto() {
        return LOTTO_STRATEGY.ticketing();
    }

    private void validate(final int payment) {
        if (payment < LOTTO_PRICE) {
            throw new IllegalArgumentException("don't have enough money.");
        }
    }
}
