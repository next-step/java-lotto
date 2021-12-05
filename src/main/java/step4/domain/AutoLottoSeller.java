package step4.domain;

import step4.domain.generator.LottoGenerator;

import java.util.stream.LongStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class AutoLottoSeller implements LottoSeller {

    private final LottoGenerator randomGenerator;

    public AutoLottoSeller(LottoGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    @Override
    public Lottos lottos(LottoPaper lottoPaper) {
        return LongStream.range(0, lottoPaper.getAutoCount())
                .mapToObj(count -> randomGenerator.generate())
                .collect(collectingAndThen(toList(), Lottos::of));
    }
}
