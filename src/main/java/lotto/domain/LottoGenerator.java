package lotto.domain;

import lotto.domain.lottoStrategy.LottoGenerateStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {

    public Lottos generateLottos(int lottoCount, LottoGenerateStrategy lottoPickStrategy) {
        List<Lotto> lottos = IntStream.range(0, lottoCount)
                .mapToObj(lottoPickStrategy::generateLotto)
                .collect(Collectors.toList());

        return new Lottos(lottos);
    }
}