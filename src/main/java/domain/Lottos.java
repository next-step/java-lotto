package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static domain.LottoStandard.*;

public class Lottos {
    private final int ZERO = 0;
    private final int FIRST_COUNT = 1;

    private List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos from(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public static Lottos combineLottos(Lottos manual, Lottos auto) {
        List<Lotto> manualLottos = manual.getLottos();
        List<Lotto> autoLottos = auto.getLottos();

        List<Lotto> lottos = Stream.concat(manualLottos.stream(), autoLottos.stream())
                .collect(Collectors.toList());
        return new Lottos(lottos);
    }

    public Map<Integer, Integer> compileLottoStatistics(LottoNumbers winningLotto, int bonusNumber) {
        List<LottoPrize> lottoPrizes = matchLottoPrize(winningLotto, bonusNumber);

        Map<Integer, Integer> matchMap = new HashMap<>();
        lottoPrizes.forEach(lottoPrize -> matchMap.merge(lottoPrize.getPrize(), FIRST_COUNT, Integer::sum));

        IntStream.range(MATCH_BEGINNING.getStandardNumber(), MATCH_ENDING.getStandardNumber())
                .filter(key -> !matchMap.containsKey(key))
                .forEach(key -> matchMap.put(key, ZERO));

        return matchMap;
    }

    private List<LottoPrize> matchLottoPrize(LottoNumbers winningLotto, int bonusNumber) {
        return lottos.stream()
                .map(lotto -> lotto.matchLottoNumbers(winningLotto, bonusNumber))
                .filter(lottoPrize -> lottoPrize != null &&
                        lottoPrize.getMatchNumber() >= MATCH_BEGINNING.getStandardNumber())
                .collect(Collectors.toList());
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
