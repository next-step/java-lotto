package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {

    public Lottos generateLottos(LottoCount lottoCount, LottoGenerateStrategy lottoPickStrategy) {
        List<Lotto> lottos = IntStream.range(0, lottoCount.getCount())
                .mapToObj(lottoPickStrategy::generateLotto)
                .collect(Collectors.toList());

        return new Lottos(lottos);
    }
}