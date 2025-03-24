package lotto.domain.result;


import java.util.HashMap;
import java.util.Map;

public class LottoResult {
  private Map<WinningRank, Integer> matchCount;
  private double profitRate;

  public LottoResult() {
    this.matchCount = new HashMap<>();
    this.profitRate = 0;
  }

  public void setMatchCount(Map<WinningRank, Integer> matchCount) {
    this.matchCount = matchCount;
  }

  public void setProfitRate(double profitRate) {
    this.profitRate = profitRate;
  }

  public Map<WinningRank, Integer> getMatchCount() {
    return matchCount;
  }

  public double getProfitRate() {
    return profitRate;
  }
}
