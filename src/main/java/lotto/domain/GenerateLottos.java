package lotto.domain;

import lotto.strategy.NumberStrategy;

import java.util.List;

public class GenerateLottos {

    public static List<Lotto> autoGenerateLottos(int autoCount, NumberStrategy numberStrategy) {
        return numberStrategy.create(autoCount);
    }
}
