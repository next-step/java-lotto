package lotto.domain.lotto.strategy;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoGeneratingStrategy extends LottoGeneratingStrategy {
    @Override
    public Lottos lottos(int totalNumberOfLottoToPurchase, Lottos manualLottos) {
        List<Lotto> lottos = IntStream.range(START_OF_RANGE, totalNumberOfLottoToPurchase)
                .mapToObj(i -> automaticLotto())
                .collect(Collectors.toList());

        return Lottos.valueOf(lottos);
    }
}
