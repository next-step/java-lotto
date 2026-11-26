package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private static final int RATE_SCALE = 100;

    private final Map<Prize, Integer> counts;
    private final int purchaseAmount;

    public LottoResult(List<Lotto> lottos, WinningLotto winningLotto, int purchaseAmount) {
        this.counts = initializeCounts();
        this.purchaseAmount = purchaseAmount;
        for (Lotto lotto : lottos) {
            Prize prize = Prize.fromCount(winningLotto.matchCount(lotto));
            counts.put(prize, counts.get(prize) + 1);
        }
    }

    public int countOf(Prize prize) {
        return counts.get(prize);
    }

    public long totalPrize() {
        long total = 0;
        for (Prize prize : Prize.values()) {
            total += (long) prize.getMoney() * countOf(prize);
        }
        return total;
    }

    public double profitRate() {
        double rate = (double) totalPrize() / purchaseAmount;
        return Math.floor(rate * RATE_SCALE) / RATE_SCALE;
    }

    private Map<Prize, Integer> initializeCounts() {
        Map<Prize, Integer> counts = new HashMap<>();
        for (Prize prize : Prize.values()) {
            counts.put(prize, 0);
        }
        return counts;
    }
}
