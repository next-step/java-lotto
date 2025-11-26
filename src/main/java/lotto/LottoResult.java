package lotto;

import java.util.Map;

public class LottoResult {

  private final Map<Integer, Integer> matchCounts;
  private final ProfitRate profitRate;

  public LottoResult(Map<Integer, Integer> matchCounts, PurchaseAmount amount) {
    this.matchCounts = matchCounts;
    this.profitRate = new ProfitRate(matchCounts, amount);
  }

  public Map<Integer, Integer> matchCounts() {
    return matchCounts;
  }

  public ProfitRate profitRate() {
    return profitRate;
  }
}
