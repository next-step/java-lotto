package lotto3.domain;

public enum Prize {
  NONE(0, 0),
  FIFTH(3, 5000),
  FOURTH(4, 50000),
  THIRD(5, 1500000),
  SECOND(5, 30000000),
  FIRST(6, 2000000000);

  private final int matchCount;
  private final int prizeMoney;

  Prize(int matchCount, int prizeMoney) {
    this.matchCount = matchCount;
    this.prizeMoney = prizeMoney;
  }

  public static Prize valueOfMatchCount(int matchCount) {
    for (Prize prize : values()) {
      if (prize.matchCount == matchCount) {
        return prize;
      }
    }
    return NONE;
  }

  public static Prize valueOfMatchCountAndBonusNumber(int matchCount, boolean isMatchedBonusNumber) {
    if (matchCount == 5 && isMatchedBonusNumber) {
      return SECOND;
    }
    return valueOfMatchCount(matchCount);
  }

  public int getMatchCount() {
    return matchCount;
  }

  public int getPrizeMoney() {
    return prizeMoney;
  }
}
