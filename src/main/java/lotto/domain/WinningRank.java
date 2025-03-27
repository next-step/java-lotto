package lotto.domain;

import java.util.Arrays;

public enum WinningRank {
  THREE_MATCH(3, false, 5_000),
  FOUR_MATCH(4, false, 50_000),
  FIVE_MATCH(5, false, 1_500_000L),
  FIVE_MATCH_BONUS(5, true, 30_000_000L),
  SIX_MATCH(6, false, 2_000_000_000L);

  private final int matchCount;
  private final boolean matchBonus;
  private final long price;

  WinningRank(int matchCount, boolean matchBonus, long price) {
    this.matchCount = matchCount;
    this.matchBonus = matchBonus;
    this.price = price;
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
