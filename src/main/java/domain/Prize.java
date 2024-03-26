package domain;

import java.util.Arrays;

public enum Prize {
  FIRST(6, 2_000_000_000),
  SECOND(5, 30_000_000),
  THIRD(5, 1_500_000),
  FOURTH(4, 50_000),
  FIFTH(3, 5_000);

  private final int matchCount;
  private final int prizeMoney;

  Prize(int matchCount, int prizeMoney) {
    this.matchCount = matchCount;
    this.prizeMoney = prizeMoney;
  }

  public static Integer findPrizeMoneyByCount(int matchCount) {
    return Arrays.stream(values())
                  .filter(e -> e.matchCount ==  matchCount).map(Prize::getPrizeMoney)
                  .findFirst().orElse(0);
  }

  private static int getPrizeMoney(Prize prize) {
    return prize.prizeMoney;
  }

}
