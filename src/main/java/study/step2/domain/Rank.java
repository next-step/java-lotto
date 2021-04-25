package study.step2.domain;

import java.util.Arrays;

public enum Rank {

  FIRST(6,2_000_000_000),
  SECOND(5,15_000_000),
  THIRD(4,50_000),
  FOURTH(3,5_000),
  MISS(0,0);

  private final int matchCount;
  private final int prizeMoney;

  Rank(int matchCount, int prizeMoney) {
    this.matchCount = matchCount;
    this.prizeMoney = prizeMoney;
  }

  public int getMatchCount() {
    return matchCount;
  }

  public int getPrizeMoney() {
    return prizeMoney;
  }

  public static Rank find(long count){
    return Arrays.stream(values())
        .filter(rank -> rank.matchCount == count)
        .findFirst()
        .orElse(MISS);
  }

}
