package lotto;

import java.util.Arrays;
import java.util.Map;

public enum Rank {
  FIRST(6, 2_000_000_000),
  SECOND(5, 30_000_000),
  // THIRD(5, 1_500_000),
  FOURTH(4, 50_000),
  FIFTH(3, 5_000),
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

  public static int calculateTotalReward(Map<Rank, Integer> hitHistory, boolean f) {
    return Arrays.stream(Rank.values())
        .map(rank -> hitHistory.get(rank) * rank.winningReward)
        .reduce(0, Integer::sum);
  }

  public static int getRewardFromNumHit(int numHit) {
    return Arrays.stream(Rank.values())
        .filter(rank -> rank.numHit == numHit)
        .findAny()
        .orElse(MISS).winningReward;
  }
}
