package lotto.domain;

import java.util.Map;

public class LottoStatistics {

  private final Map<PrizeRank, Integer> statistics;
  private final int totalTickets;
  private final int pricePerLotto;

  public LottoStatistics(Map<PrizeRank, Integer> statistics, int totalTickets, int pricePerLotto) {
    this.statistics = statistics;
    this.totalTickets = totalTickets;
    this.pricePerLotto = pricePerLotto;
  }

  public double calculateProfitRate() {
    int totalPrize = statistics.entrySet().stream()
        .mapToInt(entry -> entry.getValue() * entry.getKey().getPrizeMoney())
        .sum();

    int totalCost = totalTickets * pricePerLotto;
    return ((double) totalPrize / totalCost);
  }

  public Map<PrizeRank, Integer> getRankCounts() {
    return statistics;
  }
}