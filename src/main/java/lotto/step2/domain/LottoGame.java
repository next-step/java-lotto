package lotto.step2.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGame {

    private final static int LOTTO_START_INCLUSIVE_VALUE = 0;
    private Lottos lottos;

    private LottoGame(final int lottoAmount) {
        LottoGenerator lottoGenerator = LottoGenerator.getInstance();
        List<Lotto> lottoList = IntStream.range(LOTTO_START_INCLUSIVE_VALUE, lottoAmount)
                .mapToObj(i ->
                        Lotto.of(lottoGenerator.generateShuffledNumbers())
                )
                .collect(Collectors.toList());

        this.lottos = Lottos.of(lottoList);
    }

    public static LottoGame of(final int lottoAmount) {
        return new LottoGame(lottoAmount);
    }

    public Lottos getLottos() {
        return lottos;
    }
}
