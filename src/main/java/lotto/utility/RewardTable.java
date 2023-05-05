package lotto.utility;

import java.util.Arrays;
import java.util.function.Function;

//
public enum RewardTable {
  fourthRank(3, (times) -> times * 5000),
  thirdRank(4, (times) -> times * 50000),
  secondRank(5, (times) -> times * 1500000),
  firstRank(6, (times) -> times * 2000000000),
  ;

  public static final int MINIMUM_MATCH_NUMBER = 3;
  private final int matchNumber;
  private Function<Integer, Integer> times;

  RewardTable(int matchNumber, Function<Integer, Integer> times) {
    this.matchNumber = matchNumber;
    this.times = times;
  }

  public int calculateReward(int times) {
    return this.times.apply(times);
  }

  public int amountOfReward() {
    return this.times.apply(1);
  }

  public static RewardTable rewardTableInfo(int matchNumber) {
    return Arrays.stream(values())
        .filter(rank -> rank.matchNumber == matchNumber)
        .findAny()
        .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 등수입니다"));
  }

}
