package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Analyzer {

    private final WinningLotto winningLotto;

    public Analyzer(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public Report analyze(Lottos lottos) {
        final Map<Prize, Integer> prizeStatus = new HashMap<>();

        List<Prize> prizes = lottos.matches(winningLotto);
        prizes.forEach(prize -> increasePrizeCount(prize, prizeStatus));

        return new Report(prizeStatus, lottos);
    }

    void increasePrizeCount(Prize prize, Map<Prize, Integer> prizeStatus) {
        int currentCount = prizeStatus.getOrDefault(prize, 0);
        prizeStatus.put(prize, currentCount + 1);
    }
}
