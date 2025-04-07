package lotto.domain;

public enum PrizeRank {
  FIRST(6, false, 2_000_000_000),
  SECOND(5, true, 30_000_000),
  THIRD(5, false, 1_500_000),
  FOURTH(4, false, 50_000),
  FIFTH(3, false, 5_000),
  MISS(0, false, 0);

  private final int matchCount;
  private final boolean hasBonusBall;
  private final int prizeMoney;

  PrizeRank(int matchCount, boolean hasBonusBall, int prizeMoney) {
    this.matchCount = matchCount;
    this.hasBonusBall = hasBonusBall;
    this.prizeMoney = prizeMoney;
  }

  public static PrizeRank valueOf(int matchCount, boolean hasBonusBall) {
    for (PrizeRank rank : values()) {
      if (rank.matchCount == matchCount && rank.hasBonusBall == hasBonusBall) {
        return rank;
      }
    }
    return MISS;
  }

  public int getMatchCount() {
    return matchCount;
  }

  public boolean hasBonusBall() {
    return hasBonusBall;
  }

  public int getPrizeMoney() {
    return prizeMoney;
  }
} 