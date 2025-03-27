package lotto.domain;

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

  public static LottoPrize getPrizeFromMatchCount(int count, boolean matchesBonus) {
    return Arrays.stream(values())
            .filter(p -> p.matches(count, matchesBonus))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("일치하는 LottoPrize가 없습니다."));
  }

  public static boolean contains(int count, boolean matchesBonus) {
    return Arrays.stream(values())
            .anyMatch(p -> p.matches(count, matchesBonus));
  }

  private boolean matches(int count, boolean matchesBonus) {
    if (this.matchCount != count) return false;
    if (hasBonusVariant()) return this.isBonus == matchesBonus;
    return true;
  }

  private boolean hasBonusVariant() {
    return Arrays.stream(values())
            .filter(p -> p.matchCount == this.matchCount)
            .count() > 1;
  }

  public String getDisplayText() {
    if (this.isBonus) {
      return String.format("%d개 일치, 보너스 볼 일치(%d원)", matchCount, prizeMoney);
    }
    return String.format("%d개 일치 (%d원)", matchCount, prizeMoney);
  }

  public int getPrizeMoney() {
    return prizeMoney;
  }
}
