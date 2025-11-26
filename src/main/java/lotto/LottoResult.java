package lotto;

public class LottoResult {

  private final LottoMatchResult matchCounts;
  private final ProfitRate profitRate;

  public LottoResult(LottoMatchResult matchCounts, PurchaseAmount amount) {
    this.matchCounts = matchCounts;
    this.profitRate = new ProfitRate(matchCounts, amount);
  }

  public LottoMatchResult matchCounts() {
    return matchCounts;
  }

  public ProfitRate profitRate() {
    return profitRate;
  }
}
