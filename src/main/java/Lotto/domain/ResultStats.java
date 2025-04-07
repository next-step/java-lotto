package Lotto.domain;

import Lotto.constants.LottoPrize;

import java.util.*;

public class ResultStats {
    private final Map<LottoPrize, Integer> stats = new EnumMap<>(LottoPrize.class);
    private final int totalPrize;

    public ResultStats(List<Lotto> lottos, Set<LottoNumber> winningNumbers) {
        for (LottoPrize prize : LottoPrize.values()) {
            stats.put(prize, 0);
        }

        int prizeSum = 0;
        for (Lotto lotto : lottos) {
            int matchCount = lotto.countMatches(winningNumbers);
            LottoPrize prize = LottoPrize.fromMatchCount(matchCount);
            if (prize == null) continue;
            stats.put(prize, stats.get(prize) + 1);
            prizeSum += prize.getPrizeMoney();
        }
        this.totalPrize = prizeSum;
    }

    public int getTotalPrize() {
        return totalPrize;
    }

    public double calculateProfitRate(int totalSpent) {
        return totalPrize / (double) totalSpent;
    }

    public Map<LottoPrize, Integer> getStats() {
        return Collections.unmodifiableMap(stats);
    }
}

