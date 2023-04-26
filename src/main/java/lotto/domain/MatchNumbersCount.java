package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum MatchNumbersCount {
  MATCH_0(0, 0),
  MATCH_1(1, 0),
  MATCH_2(2, 0),
  MATCH_3(3, 5_000),
  MATCH_4(4, 50_000),
  MATCH_5(5, 1500_000),
  MATCH_6(6, 2_000_000_000),
  ;
  private static final Map<Integer, MatchNumbersCount> matchNumbersCounts = new HashMap<>();
  private final int matchNumbersCount;
  private final int prize;

  static {
    matchNumbersCounts.put(0, MATCH_0);
    matchNumbersCounts.put(1, MATCH_1);
    matchNumbersCounts.put(2, MATCH_2);
    matchNumbersCounts.put(3, MATCH_3);
    matchNumbersCounts.put(4, MATCH_4);
    matchNumbersCounts.put(5, MATCH_5);
    matchNumbersCounts.put(6, MATCH_6);
  }

  MatchNumbersCount(int matchNumbersCount, int prize) {
    this.matchNumbersCount = matchNumbersCount;
    this.prize = prize;
  }

  public static MatchNumbersCount get(int matchNumbersCount) {
    return matchNumbersCounts.get(matchNumbersCount);
  }

  public int getMatchNumbersCount() {
    return matchNumbersCount;
  }

  public int getPrize() {
    return prize;
  }
}
