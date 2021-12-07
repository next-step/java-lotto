package lotto;

import lotto.game.LottoNumberGenerateStrategy;
import lotto.game.RandomLottoNumberGenerateStrategy;
import lotto.game.Round;

public class LottoStore {
    private static final LottoNumberGenerateStrategy numberGenerateStrategy = new RandomLottoNumberGenerateStrategy();

    public static Round buy(Amount amount) {
        return new Round(amount.possibleGame(), numberGenerateStrategy);
    }
}
