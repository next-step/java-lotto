package lotto.domain.type;

import java.util.Arrays;

public enum RewardAmount {

  FIRST(6, 2000000000),
  SECOND(5, 1500000),
  THIRD(4, 50000),
  FOURTH(3, 5000),
  NONE(0, 0),
  ;

  private final int matchCount;
  private final int rewardAmount;

  RewardAmount(int matchCount, int rewardAmount) {
    this.matchCount = matchCount;
    this.rewardAmount = rewardAmount;
  }

  public static int rewardBy(int count) {
    return Arrays.stream(getValues())
        .filter(it -> it.matchCount == count)
        .findFirst()
        .map(value -> value.rewardAmount)
        .orElseGet(() -> NONE.rewardAmount);
  }

  public static RewardAmount match(int count) {
    return Arrays.stream(getValues())
        .filter(it -> it.matchCount == count)
        .findFirst()
        .orElse(NONE);
  }

  public int sum(int matchCount) {
    return this.rewardAmount * matchCount;
  }

  private static RewardAmount[] getValues() {
    return RewardAmount.values();
  }
}
