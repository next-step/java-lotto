package lotto3.domain;

import java.util.Map;

public class LottoResults {

  private final Map<Prize, Long> results;

  public LottoResults(Map<Prize, Long> results) {
    this.results = results;
  }

  public Long getMatchedCount(Prize prize) {
    return results.getOrDefault(prize, 0L);
  }

  public double calculateProfitRate(int investMoney) {
    long totalPrizeMoney = calculateTotalPrizeMoney(results);
    return (double) totalPrizeMoney / investMoney;
  }

  private long calculateTotalPrizeMoney(Map<Prize, Long> lottoResults) {
    long totalPrizeMoney = 0;
    for(Prize prize : Prize.values()) {
      totalPrizeMoney += prize.getPrizeMoney() * lottoResults.getOrDefault(prize, 0L);
    }
    return totalPrizeMoney;
  }
}
