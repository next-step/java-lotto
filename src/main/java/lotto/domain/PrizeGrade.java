package lotto.domain;

import java.util.Arrays;

public enum PrizeGrade {
  FIRST_CLASS(6, false, 2_000_000_000),
  SECOND_CLASS(5, true, 30_000_000),
  THIRD_CLASS(5, false, 1_500_000),
  FOURTH_CLASS(4, false, 50_000),
  FIFTH_CLASS(3, false, 5_000),
  FAIL(-1, false, 0);

  private final int matchCount;
  private final boolean bonusMatch;
  private final long prizeMoney;

  public static PrizeGrade of(int matchCount, boolean isHaveBonusNumber) {
    return Arrays.stream(PrizeGrade.values())
        .filter(prizeGrade -> prizeGrade.getMatchCount() == matchCount)
        .filter(prizeGrade -> prizeGrade.bonusMatch == isHaveBonusNumber)
        .findFirst()
        .orElse(FAIL);
  }

  PrizeGrade(int matchCount, boolean bonusMatch, long prizeMoney) {
    this.matchCount = matchCount;
    this.bonusMatch = bonusMatch;
    this.prizeMoney = prizeMoney;
  }

  public long getPrizeMoney() {
    return prizeMoney;
  }

  public int getMatchCount() {
    return matchCount;
  }
}
