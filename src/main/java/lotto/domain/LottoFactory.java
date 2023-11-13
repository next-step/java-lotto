package lotto.domain;

import lotto.strategy.RandomLottoGenerator;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {
    public Lottos generateLottos(int lottoCount) {
        Map<Integer, List<Lotto>> lottos = IntStream.range(0, lottoCount)
                .boxed()
                .collect(Collectors.toMap(
                        index -> index,
                        index -> List.of(new Lotto(new RandomLottoGenerator()))
                ));
        return new Lottos(lottos);
    }
}
