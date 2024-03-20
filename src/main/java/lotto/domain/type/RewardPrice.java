package lotto.domain.type;

import java.util.Arrays;

public enum RewardPrice {

  FIRST(6, 2000000000),
  SECOND(5, 1500000),
  THIRD(4, 50000),
  FOURTH(3, 5000),
  NONE(0, 0),
  ;

  private final int matchCount;
  private final int amount;

  RewardPrice(int matchCount, int amount) {
    this.matchCount = matchCount;
    this.amount = amount;
  }

  public static int rewardBy(int count) {
    return Arrays.stream(getValues())
        .filter(it -> it.matchCount == count)
        .findFirst()
        .map(value -> value.amount)
        .orElseGet(() -> NONE.amount);
  }

  public static RewardPrice match(int count) {
    return Arrays.stream(getValues())
        .filter(it -> it.matchCount == count)
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

  private static RewardPrice[] getValues() {
    return RewardPrice.values();
  }
}
