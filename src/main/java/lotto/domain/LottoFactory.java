package lotto.domain;

import lotto.strategy.RandomLottoGenerator;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {
    public Map<Integer, List<Lotto>> generateLottos(int lottoCount) {
        return IntStream.range(0, lottoCount)
                .boxed()
                .collect(Collectors.toMap(
                        index -> index,
                        index -> List.of(new Lotto(new RandomLottoGenerator()))
                ));
    }
}
