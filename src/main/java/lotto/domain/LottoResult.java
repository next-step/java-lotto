package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private Map<LottoMachine.LottoPrize, Integer> winStats = new HashMap<>();

    public void addResult(LottoMachine.LottoPrize lottoPrize) {
        if (lottoPrize == null) return;
        winStats.merge(lottoPrize, 1, (a, b) -> a + 1);
    }

    public int getCountByMatchCount(int matchCount) {
        return winStats.getOrDefault(LottoMachine.LottoPrize.findPrize(matchCount), 0);
    }

    public double getRatePercent() {
        return getTotalPrize() / getMoney();
    }

    private int getMoney() {
        int count = 0;
        for (int ticketCount:this.winStats.values()) {
            count += ticketCount;
        }
        return count * LottoStore.LOTTO_GAME_FEE;
    }

    private double getTotalPrize() {
        return this.winStats.keySet()
                .stream()
                .mapToDouble(lottoPrize -> lottoPrize.sum(winStats.get(lottoPrize)))
                .sum();
    }
}

