package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {
    private final Map<Integer, List<Lotto>> lottos;

    public Lottos(Map<Integer, List<Lotto>> lottos) {
        this.lottos = lottos;
    }

    public Map<Long, Long> winCounts(List<Integer> winLottoNumbers) {
        Map<Long, Long> initLottoResults = Stream.of(3L, 4L, 5L, 6L)
                .collect(Collectors.toMap(matchCount -> matchCount, matchCount -> 0L));

        Map<Long, Long> finalLottoResult = lottos.values().stream()
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(
                        lotto -> lotto.matchCount(winLottoNumbers),
                        Collectors.counting()
                ));

        finalLottoResult.forEach((matchCount, winCount) -> initLottoResults.merge(matchCount, winCount, Long::sum));

        return initLottoResults;
    }

    public Map<Integer, List<Lotto>> getLottos() {
        return Collections.unmodifiableMap(lottos);
    }
}
