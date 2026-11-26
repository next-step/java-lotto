package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<Prize, Integer> counts;

    public LottoResult(List<Lotto> lottos, WinningLotto winningLotto) {
        counts = initializeCounts();
        for (Lotto lotto : lottos) {
            Prize prize = Prize.fromCount(winningLotto.matchCount(lotto));
            counts.put(prize, counts.get(prize) + 1);
        }
    }

    public int countOf(Prize prize) {
        return counts.get(prize);
    }

    private Map<Prize, Integer> initializeCounts() {
        Map<Prize, Integer> counts = new HashMap<>();
        for (Prize prize : Prize.values()) {
            counts.put(prize, 0);
        }
        return counts;
    }
}
