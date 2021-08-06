package lotto.model;

import lotto.strategy.AutoLottoStrategy;
import lotto.strategy.LottoRuleStrategy;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.rangeClosed;
import static lotto.model.LottoNumber.MAX_OF_LOTTO_NUMBER;
import static lotto.model.LottoNumber.MIN_OF_LOTTO_NUMBER;

public class LottoShop {
    private static final LottoRuleStrategy LOTTO_STRATEGY = AutoLottoStrategy.getInstance();
    private static final Set<LottoNumber> LOTTO_NUMBERS_RANGE = new HashSet<>();

    public static final int LOTTO_PRICE = 1_000;

    static {
        rangeClosed(MIN_OF_LOTTO_NUMBER, MAX_OF_LOTTO_NUMBER)
                .mapToObj(LottoNumber::from)
                .forEach(LOTTO_NUMBERS_RANGE::add);
    }

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
        return LOTTO_STRATEGY.ticketing(LOTTO_NUMBERS_RANGE);
    }

    private void validate(final int payment) {
        if (payment < LOTTO_PRICE) {
            throw new IllegalArgumentException("don't have enough money.");
        }
    }
}
