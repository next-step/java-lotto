package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private Map<Integer, Integer> stats = new HashMap<>();
    private double totalPrize = 0l;
    private int buyedTicketCount = 0;

    public void addResult(int matchCount) {
        stats.merge(matchCount, 1, (a, b) -> a + 1);
        totalPrize += LottoMchine.LottoPrize.findPize(matchCount);
        buyedTicketCount++;
    }

    public int getCountByMatchCount(int matchCount) {
        return stats.getOrDefault(matchCount, 0);
    }

    public double getTotalPrize() {
        return totalPrize;
    }

    public double getRatePercent() {
        return totalPrize / (buyedTicketCount * LottoMchine.LOTTO_GAME_FEE);
    }
}

