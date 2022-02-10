package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import lotto.domain.strategy.GenerateStrategy;

public class LottoGenerator {

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    private final Lotto lotto;

    public LottoGenerator(GenerateStrategy strategy) {
        lotto = Lotto.from(new ArrayList<>(generatorLotto(strategy)));
    }

    public static LottoGenerator of(GenerateStrategy strategy) {
        return new LottoGenerator(strategy);
    }

    public Lotto getLotto() {
        return lotto;
    }

    private HashSet<Integer> generatorLotto(GenerateStrategy strategy) {
        HashSet<Integer> lotto = new HashSet<>();

        while (lotto.size() < LOTTO_SIZE) {
            lotto.add(strategy.generateNumber(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER));
        }

        return lotto;
    }
}
