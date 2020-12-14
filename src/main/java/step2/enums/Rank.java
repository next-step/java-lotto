package step2.enums;

import java.util.Arrays;

public enum Rank {
  ZERO(0, 0, "0개 일치"),
  FIFTH(3, 5000, "3개 일치"),
  FOURTH(4, 50000, "4개 일치"),
  THIRD(5, 1500000, "5개 일치"),
  SECOND(5, 30000000, "5개 일치, 보너스 볼 일치"),
  FIRST(6, 2000000000, "6개 일치");

  private final int matchCount;
  private final int reward;
  private final String displayName;

  Rank(int matchCount, int reward, String displayName) {
    this.matchCount = matchCount;
    this.reward = reward;
    this.displayName = displayName;
  }

  public int getMatchCount() {
    return this.matchCount;
  }

  public int getReward() {
    return this.reward;
  }

  public String getDisplayName() {
    return displayName;
  }

  public static Rank of(int matchCount, boolean hasBonus) {
    return Arrays.stream(values())
        .filter(rank -> rank.matchCount == matchCount)
        .filter(rank -> !SECOND.equals(rank))
        .findFirst()
        .map(rank -> {
          if(THIRD.equals(rank) && hasBonus) {
            return SECOND;
          }
          return rank;
        }).orElse(ZERO);
  }
}
