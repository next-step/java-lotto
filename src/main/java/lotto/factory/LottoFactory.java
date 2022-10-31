package lotto.factory;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.Lottos;
import lotto.strategy.LottoNumbersStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {

    public static final int LOTTO_AMOUNT = 1000;

    private LottoFactory() {
    }

    public static Lotto createLotto(final LottoNumbersStrategy lottoNumbersStrategy) {
        return new Lotto(lottoNumbersStrategy.generate());
    }

    public static Lottos createLottos(final LottoNumbersStrategy lottoNumbersStrategy, final int lottoPurchaseCount) {
        List<Lotto> lottos = IntStream.rangeClosed(1, lottoPurchaseCount)
                                      .mapToObj(order -> LottoFactory.createLotto(lottoNumbersStrategy))
                                      .collect(Collectors.toList());
        return new Lottos(lottos);
    }

    public static Lottos createLottos(final List<LottoNumbers> lottoNumbersList) {
        return new Lottos(lottoNumbersList.stream()
                                          .map(Lotto::new)
                                          .collect(Collectors.toList()));
    }
}
