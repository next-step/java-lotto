package lotto.domain;

public enum PrizeRank {
  FIFTH(3, 5000),
  FOURTH(4, 50000),
  THIRD(5, 1500000),
  SECOND(5, 30000000, true),
  FIRST(6, 2000000000);

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
    return null;
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