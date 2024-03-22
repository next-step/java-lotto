package lotto.domain.lotto;

import lotto.domain.lotto.strategy.LottoGeneratingStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoStore {
    private static final int START_OF_RANGE = 0;

    private LottoStore() {
    }

    public static Lottos purchaseLotto(LottoGeneratingStrategy lottoGeneratingStrategy, int numberOfLottoToPurchase) {
        List<Lotto> lottos = IntStream.range(START_OF_RANGE, numberOfLottoToPurchase)
                .mapToObj(i -> lottoGeneratingStrategy.lotto())
                .collect(Collectors.toList());

        return Lottos.valueOf(lottos);
    }
}
