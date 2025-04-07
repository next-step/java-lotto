package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
  private final Map<Rank, Integer> rankCounts;

  public LottoResult() {
    this.rankCounts = new HashMap<>();
    initializeRankCounts();
  }

  private void initializeRankCounts() {
    for (Rank rank : Rank.values()) {
      rankCounts.put(rank, 0);
    }
  }

  public void addRank(Rank rank) {
    rankCounts.put(rank, rankCounts.get(rank) + 1);
  }

  public int getRankCount(Rank rank) {
    return rankCounts.getOrDefault(rank, 0);
  }

  public Map<Rank, Integer> getRankCounts() {
    return new HashMap<>(rankCounts);
  }

  public long calculateTotalPrize() {
    return rankCounts.entrySet().stream()
        .mapToLong(entry -> (long) entry.getKey().getWinningMoney() * entry.getValue())
        .sum();
  }

  public double calculateProfitRate(int purchaseAmount) {
    return (double) calculateTotalPrize() / purchaseAmount;
  }
}
