package step4.domain;

import step4.domain.generator.LottoGenerator;
import step4.domain.generator.StringLottoGenerator;

import java.util.stream.LongStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LottoSeller {

    private final LottoGenerator randomGenerator;

    public LottoSeller(LottoGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public Lottos buy(LottoPaper lottoPaper) {
        Lottos manualLottos = manualLottos(lottoPaper);

        Lottos autoLottos = autoLottos(lottoPaper);

        return manualLottos.addLottos(autoLottos);
    }

    private Lottos autoLottos(LottoPaper lottoPaper) {
        Lottos autoLottos = LongStream.range(0, lottoPaper.getAutoCount())
                .mapToObj(count -> randomGenerator.generate())
                .collect(collectingAndThen(toList(), Lottos::of));
        return autoLottos;
    }

    private Lottos manualLottos(LottoPaper lottoPaper) {
        Lottos manualLottos = lottoPaper.getManualList().stream()
                .map(StringLottoGenerator::new)
                .map(LottoGenerator::generate)
                .collect(collectingAndThen(toList(), Lottos::of));
        return manualLottos;
    }
}
