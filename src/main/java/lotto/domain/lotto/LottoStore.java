package lotto.domain.lotto;

import lotto.domain.lotto.strategy.LottoGeneratingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoStore {
    private static final int START_OF_RANGE = 0;

    public static Lottos purchaseLotto(LottoGeneratingStrategy lottoGeneratingStrategy, int numberOfLottoToPurchase) {
        List<Lotto> lottos = new ArrayList<>();

        IntStream.range(START_OF_RANGE, numberOfLottoToPurchase)
                .forEach((i) -> lottos.add(lottoGeneratingStrategy.lotto()));

        return Lottos.valueOf(lottos);
    }
}
