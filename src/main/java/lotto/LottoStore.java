package lotto;

import lotto.game.NumberGenerateStrategy;
import lotto.game.RandomNumberGenerateStrategy;
import lotto.game.Round;

public class LottoStore {
    private static final int LOTTO_PRICE = 1000;
    private static final NumberGenerateStrategy numberGenerateStrategy = new RandomNumberGenerateStrategy();

    public static Round buy(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(String.format("Amount must multiple of %s", LOTTO_PRICE));
        }
        int count = amount / LOTTO_PRICE;
        return new Round(count, numberGenerateStrategy);
    }
}
