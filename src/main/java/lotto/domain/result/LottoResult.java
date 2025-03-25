package lotto.domain.result;

import java.util.Collections;
import java.util.Map;

public class LottoResult {
  private final Map<WinningRank, Integer> matchCount;
  private final double profitRate;

  public LottoResult(Map<WinningRank, Integer> matchCount, double profitRate) {
    this.matchCount = Collections.unmodifiableMap(matchCount);
    this.profitRate = profitRate;
  }

  public Map<WinningRank, Integer> getMatchCount() {
    return matchCount;
  }

  public double getProfitRate() {
    return profitRate;
  }
}
