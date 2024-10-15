package lotto.model;

import lotto.util.BonusCreator;
import lotto.util.NumbersCreator;

import java.util.*;

public class Buyer {

    private final List<Lotto> lottoes;
    private Buyer(final List<Lotto> lottoes) {
        this.lottoes = Collections.unmodifiableList(lottoes);
    }

    public static Buyer of(final int buyCount, final NumbersCreator numbersCreator, final BonusCreator bonusCreator) {
        List<Lotto> result = new ArrayList<>();
        for (int index = 0; index < buyCount; index++) {
            result.add(Lotto.of(numbersCreator, bonusCreator));
        }
        return new Buyer(result);
    }

    public List<Lotto> value() {
        return this.lottoes;
    }
}
