package lotto.domain;

import lotto.strategy.NumberStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class GenerateLottos {

    public static List<Lotto> autoGenerateLottos(int autoCount, NumberStrategy numberStrategy) {
        return numberStrategy.create(autoCount);
    }

    public static List<Lotto> manualGenerateLottos(List<String> manualNumbers) {
        return manualNumbers.stream()
                .map(Lotto::new).collect(Collectors.toList());
    }
}
