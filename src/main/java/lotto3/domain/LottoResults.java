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

  public double calculateProfitRate(Money investMoney) {
    long totalPrizeMoney = calculateTotalPrizeMoney();
    return investMoney.profitRate(totalPrizeMoney);
  }

  private long calculateTotalPrizeMoney() {
    long totalPrizeMoney = 0;
    for(Prize prize : Prize.values()) {
      totalPrizeMoney += prize.getPrizeMoney() * getMatchedCount(prize);
    }
    return totalPrizeMoney;
  }
}
