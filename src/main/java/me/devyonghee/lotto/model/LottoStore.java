package me.devyonghee.lotto.model;

import java.util.Objects;

public final class LottoStore {

    public static final int LOTTO_PRICE = 1_000;
    private static final int MIN_MONEY = 0;
    private static final String NEGATIVE_MONEY_ERROR_MESSAGE = "money(%d) must not be negative";
    private static final String NULL_GENERATOR_ERROR_MESSAGE = "generator must not be null";
    private static final String EXCEED_AVAILABLE_QUANTITY_ERROR_MESSAGE_FORMAT = "manual lottos size(%d) is exceeded available quantity(%d)";

    private final int money;
    private final LottoGenerator generator;

    private LottoStore(int money, LottoGenerator generator) {
        Objects.requireNonNull(generator, NULL_GENERATOR_ERROR_MESSAGE);
        validateNegative(money);
        this.generator = generator;
        this.money = money;
    }

    public static LottoStore of(int money, LottoGenerator generator) {
        return new LottoStore(money, generator);
    }

    public Lottos lottos() {
        Lottos manualLottos = generator.manualLottos();
        return manualLottos.merge(
                generator.autoLottos(validatedRestCount(manualLottos))
        );
    }

    private int validatedRestCount(Lottos lottos) {
        int availableQuantity = availableQuantity();
        int restCount = availableQuantity - lottos.size();
        if (restCount < 0) {
            throw new IllegalStateException(String.format(EXCEED_AVAILABLE_QUANTITY_ERROR_MESSAGE_FORMAT, lottos.size(), availableQuantity));
        }
        return restCount;
    }

    private void validateNegative(int money) {
        if (money < MIN_MONEY) {
            throw new IllegalArgumentException(String.format(NEGATIVE_MONEY_ERROR_MESSAGE, money));
        }
    }

    private int availableQuantity() {
        return money / LOTTO_PRICE;
    }
}
