package lotto2.domain;

public enum Prize {
  NONE(0, 0),
  FOURTH(3, 5000),
  THIRD(4, 50000),
  SECOND(5, 1500000),
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

  public int getMatchCount() {
    return matchCount;
  }

  public int getPrizeMoney() {
    return prizeMoney;
  }
}
