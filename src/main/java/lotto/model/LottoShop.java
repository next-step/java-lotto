package lotto.model;

import java.util.Objects;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LottoShop {
    private static final LottoMachine LOTTO_MACHINE = LottoMachine.getInstance();

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

    private void validate(final int payment) {
        if (payment < LOTTO_PRICE) {
            throw new IllegalArgumentException("don't have enough money.");
        }
    }

    private Lotto getLotto() {
        return LOTTO_MACHINE.auto();
    }
}
