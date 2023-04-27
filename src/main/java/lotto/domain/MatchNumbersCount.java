package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum MatchNumbersCount {
  MATCH_0(0, 0),
  MATCH_1(1, 0),
  MATCH_2(2, 0),
  MATCH_3(3, 5_000),
  MATCH_4(4, 50_000),
  MATCH_5(5, 1_500_000),
  MATCH_6(6, 2_000_000_000),
  ;
  private static final Map<Integer, MatchNumbersCount> matchNumbersCounts = new HashMap<>();
  private final int matchNumbersCount;
  private final int prize;

  static {
    for (MatchNumbersCount value : values()) {
      matchNumbersCounts.put(value.matchNumbersCount, value);
    }
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
