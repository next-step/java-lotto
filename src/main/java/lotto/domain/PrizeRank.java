package lotto.domain;

import java.util.Arrays;

public enum PrizeRank {
  FIRST(new MatchResultStrategy(6, false), 2_000_000_000),
  SECOND(new MatchResultStrategy(5, true), 30_000_000),
  THIRD(new MatchResultStrategy(5, false), 1_500_000),
  FOURTH(new MatchResultStrategy(4, false), 50_000),
  FIFTH(new MatchResultStrategy(3, false), 5_000),
  MISS(new MatchResultStrategy(0, false), 0);

  private final MatchStrategy matchStrategy;
  private final int prizeMoney;

  PrizeRank(MatchStrategy matchStrategy, int prizeMoney) {
    this.matchStrategy = matchStrategy;
    this.prizeMoney = prizeMoney;
  }

  public static PrizeRank valueOf(int matchCount, boolean hasBonusBall) {
    return Arrays.stream(values())
        .filter(rank -> rank.matchStrategy.matches(matchCount, hasBonusBall))
        .findFirst()
        .orElse(MISS);
  }

  public int getMatchCount() {
    return matchStrategy.getMatchCount();
  }

  public boolean hasBonusBall() {
    return matchStrategy.requiresBonusBall();
  }

  public int getPrizeMoney() {
    return prizeMoney;
  }
} 