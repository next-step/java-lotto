package lotto;

import java.util.Map;

public class LottoMatchResult {

  private final Map<Integer, Integer> matchResult;

  public LottoMatchResult(Map<Integer, Integer> matchResult) {
    this.matchResult = matchResult;
  }

  public int countMatches(int matchCount) {
    return matchResult.getOrDefault(matchCount, 0);
  }
}
