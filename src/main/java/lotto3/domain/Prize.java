package lotto3.domain;

public enum Prize {
  NONE(0, 0),
  FOURTH(3, 5000),
  THIRD(4, 50000),
  SECOND(5, 1500000),
  BONUS(5, 30000000),
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
    if (matchCount == 4 && isMatchedBonusNumber) {
      return BONUS;
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
