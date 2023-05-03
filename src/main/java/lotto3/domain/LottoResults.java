package lotto3.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoResults {

  private final EnumMap<Prize, Long> results;

  public LottoResults(EnumMap<Prize, Long> results) {
    this.results = results;
  }

  public Long getMatchedCount(Prize prize) {
    return results.getOrDefault(prize, 0L);
  }

  public double calculateProfitRate(Money investMoney) {
    long totalPrizeMoney = calculateTotalPrizeMoney(results);
    return investMoney.profitRate(totalPrizeMoney);
  }

  private long calculateTotalPrizeMoney(Map<Prize, Long> lottoResults) {
    long totalPrizeMoney = 0;
    for(Prize prize : Prize.values()) {
      totalPrizeMoney += prize.getPrizeMoney() * getMatchedCount(prize);
    }
    return totalPrizeMoney;
  }
}
