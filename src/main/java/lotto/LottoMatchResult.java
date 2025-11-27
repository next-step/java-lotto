package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoMatchResult {

  private final Map<Integer, Integer> matchResult = new HashMap<>();

  public void match(int match) {
    matchResult.put(match, matchResult.getOrDefault(match, 0) + 1);
  }

  public int countMatches(int matchCount) {
    return matchResult.getOrDefault(matchCount, 0);
  }

  public static LottoMatchResult of(int... matches) {
    LottoMatchResult result = new LottoMatchResult();
    for (int m : matches) {
      result.match(m);
    }
    return result;
  }
}
