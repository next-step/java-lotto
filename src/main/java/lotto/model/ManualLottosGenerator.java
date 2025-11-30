package lotto.model;

import java.util.*;
import java.util.stream.Collectors;

public class ManualLottosGenerator implements LottosGenerator {
    private final List<String> lottoStrings;

    public ManualLottosGenerator(List<String> lottoStrings) {
        this.lottoStrings = lottoStrings;
    }

    @Override
    public Lottos generate() {
        List<Lotto> lottos = this.lottoStrings.stream()
                .map(LottoFactory::createLotto)
                .toList();
        return new Lottos(lottos);
    }
}
