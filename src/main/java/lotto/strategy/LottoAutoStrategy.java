package lotto.strategy;

import java.util.Random;

import lotto.domain.Lotto;

import static java.util.stream.Collectors.toList;
import static lotto.domain.Lotto.LOTTO_NUMBER_END;
import static lotto.domain.Lotto.LOTTO_NUMBER_START;

public class LottoAutoStrategy implements LottoGenerationStrategy {
    private static final int LOTTO_NUMBER_COUNT = 6;

    @Override
    public Lotto generate() {
        return new Lotto(new Random().ints(LOTTO_NUMBER_START, LOTTO_NUMBER_END + 1)
            .distinct()
            .limit(LOTTO_NUMBER_COUNT)
            .boxed()
            .sorted()
            .collect(toList()));
    }
}
