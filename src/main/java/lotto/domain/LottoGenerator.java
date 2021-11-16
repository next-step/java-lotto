package lotto.domain;

import lotto.service.NumberGenerateStrategy;
import lotto.vo.Lottos;

import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class LottoGenerator {

    private final NumberGenerateStrategy numberGenerateStrategy;

    public LottoGenerator(NumberGenerateStrategy numberGenerateStrategy) {
        this.numberGenerateStrategy = numberGenerateStrategy;
    }

    public static LottoGenerator create(NumberGenerateStrategy numberGenerateStrategy) {
        return new LottoGenerator(numberGenerateStrategy);
    }

    public Lottos generateLotto(long count) {
        return Lottos.create(LongStream.range(0, count)
                .mapToObj(i -> numberGenerateStrategy.generate())
                .map(Lotto::create)
                .collect(Collectors.toList()));
    }
}
