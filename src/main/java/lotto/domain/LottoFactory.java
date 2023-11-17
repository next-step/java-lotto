package lotto.domain;

import lotto.strategy.RandomLottoGenerator;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {

    private LottoFactory() {
    }

    public static Lottos generateLottos(int lottoCount) {
        List<Lotto> lottos = IntStream.range(0, lottoCount)
                .mapToObj(index -> new Lotto(new LottoNumbers(new RandomLottoGenerator())))
                .collect(Collectors.toList());
        return new Lottos(lottos);
    }
}
