package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    private final int ZERO = 0;
    private final int FIRST_COUNT = 1;
    private final int PRIZE_BEGINNING = 3;
    private final int PRIZE_ENDING = 7;

    private List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos from(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public Map<Integer, Integer> compileLottoStatistics(LottoNumbers winningLotto) {
        List<Integer> matches = lottos.stream()
                .map(lotto -> lotto.matchLottoNumbers(winningLotto))
                .filter(match -> match >= PRIZE_BEGINNING)
                .collect(Collectors.toList());

        Map<Integer, Integer> matchMap = new HashMap<>();
        matches.forEach(match -> matchMap.merge(match, FIRST_COUNT, Integer::sum));

        IntStream.range(PRIZE_BEGINNING, PRIZE_ENDING)
                .filter(key -> !matchMap.containsKey(key))
                .forEach(key -> matchMap.put(key, ZERO));

        return matchMap;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
