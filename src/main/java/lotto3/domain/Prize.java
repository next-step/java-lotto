package lotto3.domain;

import java.util.Arrays;

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

  private static Prize valueOfMatchCount(int matchCount) {
    return Arrays.stream(values())
        .filter(prize -> isMatched(matchCount, prize))
        .findFirst()
        .orElse(NONE);
  }

  private static boolean isMatched(int matchCount, Prize prize) {
    return prize.matchCount == matchCount;
  }

  public static Prize valueOfMatchCountAndBonusNumber(int matchCount, boolean isMatchedBonusNumber) {
    if (isMatchedWithBonusNumber(matchCount, isMatchedBonusNumber)) {
      return SECOND;
    }
    return valueOfMatchCount(matchCount);
  }

  private static boolean isMatchedWithBonusNumber(int matchCount, boolean isMatchedBonusNumber) {
    return matchCount == 5 && isMatchedBonusNumber;
  }

  public int getMatchCount() {
    return matchCount;
  }

  public int getPrizeMoney() {
    return prizeMoney;
  }


}
