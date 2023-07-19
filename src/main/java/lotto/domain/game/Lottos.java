package lotto.domain.game;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.statistics.LottoMatch;
import lotto.domain.statistics.LottoMatchKey;

public final class Lottos {

    private final List<Lotto> lottos;

    public Lottos(
        final LottoCount lottoCount,
        final List<LottoManual> lottosManual,
        final NumberGenerator numberGenerator
    ) {
        this.lottos = generateLottos(lottoCount, lottosManual, numberGenerator);
    }

    private List<Lotto> generateLottos(
        final LottoCount lottoCount,
        final List<LottoManual> lottosManual,
        final NumberGenerator numberGenerator
    ) {
        return Stream.concat(
                generateLottosManual(lottosManual).stream(),
                generateLottosAuto(lottoCount, numberGenerator).stream())
            .collect(Collectors.toList());
    }

    private List<Lotto> generateLottosManual(final List<LottoManual> lottosManual) {
        return lottosManual.stream()
            .map(LottoManual::getLottoManual)
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

    // 통계 로직
    public Map<LottoMatch, Integer> calculateResult(final WinningNumber winningNumber) {
        Map<LottoMatch, Integer> resultMap = new EnumMap<>(LottoMatch.class);
        lottos.stream()
            .map(lotto -> getLottoMatchKey(lotto, winningNumber))
            .forEach((lottoMatchKey) -> putLotto(lottoMatchKey, resultMap));
        return resultMap;
    }

    private LottoMatchKey getLottoMatchKey(final Lotto lotto, final WinningNumber winningNumber) {
        return new LottoMatchKey(lotto.hasLottoNumber(winningNumber.getBonusBall()),
            lotto.countMatch(winningNumber.getWinningLotto()));
    }

    private void putLotto(final LottoMatchKey lottoMatchKey,
        final Map<LottoMatch, Integer> resultMap) {
        resultMap.put(LottoMatch.find(lottoMatchKey),
            resultMap.getOrDefault(LottoMatch.find(lottoMatchKey), 0) + 1);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
