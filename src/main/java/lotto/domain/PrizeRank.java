package lotto.domain;

public enum PrizeRank {
  FIRST(6, 2000000000),
  SECOND(5, 30000000, true),
  THIRD(5, 1500000),
  FOURTH(4, 50000),
  FIFTH(3, 5000),
  MISS(0, 0);

  private final int matchCount;
  private final int prizeMoney;
  private final boolean hasBonusBall;

  PrizeRank(int matchCount, int prizeMoney) {
    this(matchCount, prizeMoney, false);
  }

  PrizeRank(int matchCount, int prizeMoney, boolean hasBonusBall) {
    this.matchCount = matchCount;
    this.prizeMoney = prizeMoney;
    this.hasBonusBall = hasBonusBall;
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

  public int getPrizeMoney() {
    return prizeMoney;
  }

  public boolean hasBonusBall() {
    return hasBonusBall;
  }
} 