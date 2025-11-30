package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoMatchResult {

  private final Map<LottoRank, Integer> matchResult = new HashMap<>();

  public void match(LottoRank rank) {
    matchResult.put(rank, matchResult.getOrDefault(rank, 0) + 1);
  }

  public int countMatches(LottoRank rank) {
    return matchResult.getOrDefault(rank, 0);
  }

  public long totalPrize() {
    long totalPrize = 0;
    for (LottoRank rank : LottoRank.values()) {
      int count = countMatches(rank);
      totalPrize += (long) count * rank.prize();
    }
    return totalPrize;
  }

  public static LottoMatchResult of(int... matches) {
    LottoMatchResult result = new LottoMatchResult();
    for (int m : matches) {
      LottoRank rank = LottoRank.of(m);
      result.match(rank);
    }
    return result;
  }
}
