package lotto.model;

import java.util.*;

public class ManualLottosGenerator implements LottosGenerator {
    private final List<String> lottoStrings;

    public ManualLottosGenerator(List<String> lottoStrings) {
        this.lottoStrings = lottoStrings;
    }

    @Override
    public Lottos generate() {
        List<Lotto> lottos = this.lottoStrings.stream()
                .map(Lotto::of)
                .toList();
        return new Lottos(lottos);
    }
}
