package lotto;

import lotto.game.NumberGenerateStrategy;
import lotto.game.RandomNumberGenerateStrategy;
import lotto.game.Round;

public class LottoStore {
    private static final NumberGenerateStrategy numberGenerateStrategy = new RandomNumberGenerateStrategy();

    public static Round buy(Amount amount) {
        return new Round(amount.possibleGame(), numberGenerateStrategy);
    }
}
