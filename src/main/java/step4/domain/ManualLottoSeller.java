package step4.domain;

import step4.domain.generator.LottoGenerator;
import step4.domain.generator.StringLottoGenerator;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class ManualLottoSeller implements LottoSeller {

    @Override
    public Lottos lottos(LottoPaper lottoPaper) {
        return lottoPaper.getManuals().stream()
                .map(StringLottoGenerator::new)
                .map(LottoGenerator::generate)
                .collect(collectingAndThen(toList(), Lottos::of));
    }
}
