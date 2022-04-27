package lotto.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Rank {
  FIRST(6, 2_000_000_000),
  SECOND(5, 1_500_000),
  THIRD(4, 50_000),
  FOURTH(3, 5_000),
  MISS(0, 0);

  private final int matchCount;
  private final int prizeMoney;

  private static final Map<Integer, Rank> BY_MATCH_COUNT = Arrays.stream(values())
      .collect(Collectors.toMap(rank -> rank.matchCount, Function.identity()));

  Rank(int countOfMatch, int winningMoney) {
    this.matchCount = countOfMatch;
    this.prizeMoney = winningMoney;
  }

  public int getMatchCount() {
    return matchCount;
  }

  public int getPrizeMoney() {
    return prizeMoney;
  }

  public static Rank valueOf(int matchCount) {
    return BY_MATCH_COUNT.getOrDefault(matchCount, MISS);
  }
}
