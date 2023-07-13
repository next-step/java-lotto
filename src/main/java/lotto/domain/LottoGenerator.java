package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {

    private final LottoGenerateStrategy lottoGenerateStrategy;

    public LottoGenerator() {
        this(new RandomLottoGenerateStrategy());
    }

    public LottoGenerator(final LottoGenerateStrategy lottoGenerateStrategy) {
        this.lottoGenerateStrategy = lottoGenerateStrategy;
    }

    public BoughtLottos generate(final Money money) {
        final int buyCount = money.getValue() / Lotto.PRICE;
        final List<Lotto> boughtLottos = IntStream.range(0, buyCount)
                .mapToObj(i -> lottoGenerateStrategy.generate())
                .collect(Collectors.toList());
        return new BoughtLottos(boughtLottos);
    }
}
