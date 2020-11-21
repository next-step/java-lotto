package lotto;

import java.util.Arrays;
import java.util.Map;

public enum Rank {
  HIT_SIX(6, 2_000_000_000),
  HIT_FIVE(5, 30_000_000),
  HIT_FOUR(4, 1_500_000),
  HIT_THREE(3, 50_000),
  MISS(0, 0);

  private final int numHit;
  private final int winningReward;

  Rank(int numHit, int winningReward) {
    this.numHit = numHit;
    this.winningReward = winningReward;
  }

  public static int calculateTotalReward(Map<Integer, Integer> hitHistory) {
    int result = 0;
    for (Rank rank : Rank.values()) {
      result += hitHistory.get(rank.numHit) * rank.winningReward;
    }

    return result;
  }

  public static int getRewardFromNumHit(int numHit) {
    // !!! 된당..신기..
    return Arrays.stream(Rank.values())
        .filter(rank -> rank.numHit == numHit)
        .findAny()
        .orElse(MISS).winningReward;
  }
}
