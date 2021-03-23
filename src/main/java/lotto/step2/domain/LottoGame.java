package lotto.step2.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGame {

    private Lottos lottos;

    private LottoGame(final int lottoAmount) {
        LottoGenerator lottoGenerator = LottoGenerator.getInstance();
        List<Lotto> lottoList = IntStream.range(0, lottoAmount)
                .mapToObj(i ->
                        Lotto.of(lottoGenerator.generateShuffledNumbers())
                )
                .collect(Collectors.toList());

        this.lottos = Lottos.of(lottoList);
    }

    public static LottoGame of(final int lottoAmount) {
        return new LottoGame(lottoAmount);
    }
}
