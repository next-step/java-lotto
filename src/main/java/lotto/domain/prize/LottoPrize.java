package lotto.domain.prize;

import java.util.Arrays;

public enum LottoPrize {
  THREE_MATCHES(3, false, 5_000),
  FOUR_MATCHES(4, false, 50_000),
  FIVE_MATCHES(5, false, 1_500_000),
  FIVE_MATCHES_WITH_BONUS(5, true, 30_000_000),
  SIX_MATCHES(6, false, 2_000_000_000);

  private final int matchCount;
  private final boolean isBonus;
  private final int prizeMoney;

  LottoPrize(int matchCount, boolean isBonus, int prizeMoney) {
    this.matchCount = matchCount;
    this.isBonus = isBonus;
    this.prizeMoney = prizeMoney;
  }

  public boolean hasBonusVariant() {
    return Arrays.stream(values())
            .filter(p -> p.matchCount == this.matchCount)
            .count() > 1;
  }

  public int getPrizeMoney() {
    return prizeMoney;
  }

  public int getMatchCount() {
    return matchCount;
  }

  public boolean getIsBonus() {
    return isBonus;
  }
}
