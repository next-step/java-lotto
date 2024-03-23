package lotto.domain.type;

import java.util.Arrays;

public enum RewardPrice {

  FIRST(6, 2_000_000_000, false),
  SECOND(5, 30_000_000, true),
  THIRD(5, 1_500_000, false),
  FOURTH(4, 50_000, false),
  FIFTH(3, 5_000, false),
  NONE(0, 0, false),
  ;

  private final int matchCount;
  private final int amount;
  private final boolean isMatchBonusBall;

  RewardPrice(int matchCount, int amount, boolean isMatchBonusBall) {
    this.matchCount = matchCount;
    this.amount = amount;
    this.isMatchBonusBall = isMatchBonusBall;
  }

  public static RewardPrice match(int count, boolean isMatchBonusBall) {
    return Arrays.stream(getValues())
        .filter(it -> it.matchCount == count)
        .filter(it -> filterIsMatchBonusBall(isMatchBonusBall, it))
        .findFirst()
        .orElse(NONE);
  }

  public int sum(int matchCount) {
    return this.amount * matchCount;
  }

  public int rewardAmount() {
    return amount;
  }

  public int matchCount() {
    return matchCount;
  }

  public boolean isMatchBonusBall() {
    return isMatchBonusBall;
  }

  private static RewardPrice[] getValues() {
    return RewardPrice.values();
  }

  private static boolean filterIsMatchBonusBall(boolean isMatchBonusBall, RewardPrice it) {
    if (it.matchCount == 5) {
      return it.isMatchBonusBall == isMatchBonusBall;
    }
    return !it.isMatchBonusBall;
  }
}
