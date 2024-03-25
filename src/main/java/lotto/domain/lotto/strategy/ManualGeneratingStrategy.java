package lotto.domain.lotto.strategy;

import lotto.domain.lotto.Lottos;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ManualGeneratingStrategy extends LottoGeneratingStrategy {
    @Override
    public Lottos lottos(int totalNumberOfLottoToPurchase, Lottos manualLottos) {
        int numberOfAutoLotto = totalNumberOfLottoToPurchase - manualLottos.numberOfLottos();

        Lottos autoLottos = Lottos.valueOf(IntStream.range(START_OF_RANGE, numberOfAutoLotto)
                .mapToObj(i -> automaticLotto())
                .collect(Collectors.toList()));

        return manualLottos.bind(autoLottos);
    }
}
