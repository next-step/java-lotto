package lotto.domain;

public enum PrizeRank {
  FIFTH(3, 5000),
  FOURTH(4, 50000),
  THIRD(5, 1500000),
  FIRST(6, 2000000000);

  private final int matchCount;
  private final int prizeMoney;

  PrizeRank(int matchCount, int prizeMoney) {
    this.matchCount = matchCount;
    this.prizeMoney = prizeMoney;
  }

  public static PrizeRank valueOf(int matchCount) {
    for (PrizeRank rank : values()) {
      if (rank.matchCount == matchCount) {
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
} 