package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private Map<LottoMachine.LottoPrize, Integer> stats = new HashMap<>();

    public void addResult(LottoMachine.LottoPrize lottoPrize) {
        if (lottoPrize == null) return;
        stats.merge(lottoPrize, 1, (a, b) -> a + 1);
    }

    public int getCountByMatchCount(int matchCount) {
        return stats.getOrDefault(LottoMachine.LottoPrize.findPrize(matchCount), 0);
    }

    public double getRatePercent() {
        return getTotalPrize() / getMoney();
    }

    private int getMoney() {
        int count = 0;
        for (int ticketCount:this.stats.values()) {
            count += ticketCount;
        }
        return count * LottoStore.LOTTO_GAME_FEE;
    }

    private double getTotalPrize() {
        return this.stats.entrySet()
                .stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }
}

