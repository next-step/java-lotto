package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Long> LOTTO_MATCH_COUNTS = List.of(3L, 4L, 5L, 6L);

    private final Map<Integer, List<Lotto>> lottos;

    public Lottos(Map<Integer, List<Lotto>> lottos) {
        this.lottos = new HashMap<>(lottos);
    }

    public LottoResult winCounts(List<Integer> winLottoNumbers) {
        Map<Long, Long> initLottoResults = LOTTO_MATCH_COUNTS.stream()
                .collect(Collectors.toMap(matchCount -> matchCount, matchCount -> 0L));

        Map<Long, Long> finalLottoResult = lottos.values().stream()
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(
                        lotto -> lotto.matchCount(winLottoNumbers),
                        Collectors.counting()
                ));

        finalLottoResult.forEach((matchCount, winCount) -> initLottoResults.merge(matchCount, winCount, Long::sum));

        return new LottoResult(initLottoResults);
    }

    public Map<Integer, List<Lotto>> getLottos() {
        return Collections.unmodifiableMap(lottos);
    }
}
