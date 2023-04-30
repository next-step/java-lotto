package domain;

public enum Prize {
  MATCH_3_TIME(3, 5000),
  MATCH_4_TIME(4, 50000),
  MATCH_5_TIME(5, 1500000),
  MATCH_6_TIME(6, 2000000000),
  MATCH_NOT_THING(0, 0);

  private final int matchCount;
  private final int prizeMoney;

  Prize(int matchCount, int prizeMoney) {
    this.matchCount = matchCount;
    this.prizeMoney = prizeMoney;
  }

  public static Prize getPrizeForMatches(int matchedCount) {
    for (Prize prize : Prize.values()) {
      if (prize.matchCount == matchedCount) {
        return prize;
      }
    }
    return MATCH_NOT_THING;
  }




  public int matchCount() {
    return matchCount;
  }

  public int prizeMoney() {
    return prizeMoney;
  }
}
