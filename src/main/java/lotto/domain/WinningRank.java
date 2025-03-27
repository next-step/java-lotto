package lotto.domain;

import java.util.Arrays;

public enum WinningRank {
  THREE_MATCH(3, false, 5_000, "3개 일치"),
  FOUR_MATCH(4, false, 50_000, "4개 일치"),
  FIVE_MATCH(5, false, 1_500_000L, "5개 일치"),
  FIVE_MATCH_BONUS(5, true, 30_000_000L, "5개 일치, 보너스 볼 일치"),
  SIX_MATCH(6, false, 2_000_000_000L, "6개 일치");

  private final int matchCount;
  private final boolean matchBonus;
  private final long price;
  private final String description;

  WinningRank(int matchCount, boolean matchBonus, long price, String description) {
    this.matchCount = matchCount;
    this.matchBonus = matchBonus;
    this.price = price;
    this.description = description;
  }

  public int getMatchCount() {
    return matchCount;
  }

  public long getPrice() {
    return price;
  }

  public boolean isMatchBonus() {
    return matchBonus;
  }

  public String getDescription() {
    return description;
  }

  public static WinningRank from(int matchCount, boolean matchBonus) {
    return Arrays.stream(values())
        .filter(rank -> rank.matchCount == matchCount)
        .filter(rank -> {
          if (isFiveMatch(matchCount)) {
            return rank.matchBonus == matchBonus;
          }
          return true;
        })
        .findFirst()
        .orElse(null);
  }

  private static boolean isFiveMatch(int matchCount) {
    return matchCount == FIVE_MATCH.getMatchCount();
  }
}
