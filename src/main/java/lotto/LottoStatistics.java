package lotto;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoStatistics {
  private final Map<Integer, Integer> statistics;

  public LottoStatistics(LottoTickets lottoTickets, LottoTicket winningNumbers) {
    statistics = new HashMap<>();
    statistics.put(3, 0);
    statistics.put(4, 0);
    statistics.put(5, 0);
    statistics.put(6, 0);
    calculate(lottoTickets, winningNumbers);
  }

  private void calculate(LottoTickets lottoTickets, LottoTicket winningNumbers) {
    for (LottoTicket ticket : lottoTickets.getTickets()) {
      int matchCount = ticket.matchCount(winningNumbers);
      increment(matchCount);
    }
  }

  private void increment(int matchCount) {
    if (matchCount >= 3) {
      statistics.put(matchCount, statistics.get(matchCount) + 1);
    }
  }

  public Map<Integer, Integer> getStatistics() {
    return statistics;
  }

  public float getRateOfReturn(PurchaseAmount purchaseAmount) {
    int totalPrize = statistics.entrySet().stream()
                        .mapToInt(entry -> LottoPrize.getPrizeByMatchCount(entry.getKey()) * entry.getValue())
                        .sum();
    return purchaseAmount.calculateRateOfReturn(totalPrize);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LottoStatistics that = (LottoStatistics) o;
    return Objects.equals(statistics, that.statistics);
  }

  @Override
  public int hashCode() {
    return Objects.hash(statistics);
  }
}
