package step4.domain.result;

import step4.domain.Cash;
import step4.domain.number.Count;

import java.util.HashMap;
import java.util.Map;

public class LottoMatchingResult {
  private static final int ADDING_MIN_COUNT = 1;
  private static final int ZERO = 0;

  private final Count minimalCount = new Count(ADDING_MIN_COUNT);
  private final Map<Rank, Count> matchingCounts;

  public LottoMatchingResult() {
    matchingCounts = new HashMap<>();
  }

  public void add(Rank rank) {
    Count addingCount = matchingCounts
      .getOrDefault(rank, new Count())
      .addCount(minimalCount);
    matchingCounts.put(rank, addingCount);
  }

  public String toStringSpecificResult(Rank rank) {
    Count result = matchingCounts.getOrDefault(rank, new Count(ZERO));
    return result.toString();
  }

  public Count sendSpecificCount(Rank rank) {
    return matchingCounts.getOrDefault(rank, new Count());
  }

  public Cash calcTotalRevenue() {
    Cash result = new Cash(0L);

    for (Rank rank : matchingCounts.keySet()) {
      Count count = sendSpecificCount(rank);
      Cash prizeMoney = new Cash((long) rank.getWinningMoney());
      result = result.add(prizeMoney.multiply(count));
    }

    return result;
  }
}
