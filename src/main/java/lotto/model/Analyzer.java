package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Analyzer {

    private final Lotto winningLotto;

    public Analyzer(Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public Report analyze(Lottos lottos) {
        List<Integer> countsOfMatchingNumbers = lottos.getCountOfMatchingNumbers(winningLotto);

        final Map<Prize, Integer> prizeStatus = new HashMap<>();
        countsOfMatchingNumbers.forEach(count -> increasePrizeCount(Prize.valueOf(count), prizeStatus));
        return new Report(prizeStatus, lottos);
    }

    void increasePrizeCount(Prize prize, Map<Prize, Integer> prizeStatus) {
        int currentCount = prizeStatus.getOrDefault(prize, 0);
        prizeStatus.put(prize, currentCount + 1);
    }
}
