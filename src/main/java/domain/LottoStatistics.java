package domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {
    private final Map<Rank, Integer> statistics = new EnumMap<>(Rank.class);
    private int totalPrize = 0;

    public LottoStatistics(List<Lotto> lottos, WinningNumber winningNumber) {
        for (Lotto lotto : lottos) {
            int matchCount = lotto.matchCount(winningNumber);
            Rank rank = Rank.of(matchCount);

            if (rank != null) {
                statistics.put(rank, statistics.getOrDefault(rank, 0) + 1);
                totalPrize += rank.getPrize();
            }
        }
    }

    public int getCountByRank(Rank rank) {
        return statistics.getOrDefault(rank, 0);
    }

    public double calculateProfitRate(int purchaseAmount) {
        return (double) totalPrize / purchaseAmount;
    }
}