package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningStatisticsCalculator {

  private static final int PRICE_PER_LOTTO = 1000;
  private final Lotto winningNumbers;
  private final int bonusBall;

  public WinningStatisticsCalculator(Lotto winningNumbers, int bonusBall) {
    this.winningNumbers = winningNumbers;
    this.bonusBall = bonusBall;
  }

  public LottoStatistics calculate(List<Lotto> tickets) {
    Map<PrizeRank, Integer> statistics = initializeStatistics();
    for (Lotto ticket : tickets) {
      updateStatistics(statistics, calculatePrizeRank(ticket));
    }
    return new LottoStatistics(statistics, tickets.size(), PRICE_PER_LOTTO);
  }

  private Map<PrizeRank, Integer> initializeStatistics() {
    Map<PrizeRank, Integer> statistics = new HashMap<>();
    for (PrizeRank rank : PrizeRank.values()) {
      statistics.put(rank, 0);
    }
    return statistics;
  }

  private PrizeRank calculatePrizeRank(Lotto ticket) {
    return PrizeRank.valueOf(
        ticket.countMatchingNumbers(winningNumbers),
        ticket.hasBonusBall(bonusBall)
    );
  }

  private void updateStatistics(Map<PrizeRank, Integer> statistics, PrizeRank rank) {
    statistics.merge(rank, 1, Integer::sum);
  }
} 