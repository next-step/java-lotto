package lotto.domain.game;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Lottos {

    private final List<Lotto> lottos;

    public Lottos(
        final LottoCount lottoCount,
        final List<String> lottosManual,
        final NumberGenerator numberGenerator
    ) {
        this.lottos = generateLottos(lottoCount, lottosManual, numberGenerator);
    }

    private List<Lotto> generateLottos(
        final LottoCount lottoCount,
        final List<String> lottosManual,
        final NumberGenerator numberGenerator
    ) {
        return Stream.concat(
                generateLottosManual(lottosManual).stream(),
                generateLottosAuto(lottoCount, numberGenerator).stream())
            .collect(Collectors.toList());
    }

    private List<Lotto> generateLottosManual(final List<String> lottosManual) {
        return lottosManual.stream()
            .map(lottoManual -> new Lotto(lottoManual, false))
            .collect(Collectors.toList());
    }

    private List<Lotto> generateLottosAuto(final LottoCount lottoCount,
        final NumberGenerator numberGenerator) {
        List<Lotto> lottosAuto = new ArrayList<>();
        for (int i = 0; i < lottoCount.getAutoCount(); i++) {
            lottosAuto.add(new Lotto(numberGenerator.shuffleNumbers(), true));
        }
        return lottosAuto;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
