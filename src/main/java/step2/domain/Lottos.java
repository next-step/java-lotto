package step2.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lottos {
    public static final int LOTTO_WINNING_MIN_COUNT = 3;

    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public Map<Integer, Long> getMatchResults(Lotto winnerLotto) {
        return lottos.stream()
                .map(lotto -> lotto.matchNumberCounts(winnerLotto))
                .filter(matchedNumbers -> matchedNumbers >= LOTTO_WINNING_MIN_COUNT)
                .collect(Collectors.groupingBy(matchedNumbers -> matchedNumbers, Collectors.counting()));
    }
}
