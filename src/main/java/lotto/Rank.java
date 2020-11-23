package lotto;

import java.util.Arrays;
import java.util.Map;

public enum Rank {
  FIRST(6, 2_000_000_000),
  SECOND(5, 30_000_000),
  THIRD(5, 1_500_000),
  FOURTH(4, 50_000),
  FIFTH(3, 5_000),
  MISS(0, 0);

  private final int numHit;
  private final int winningReward;

  Rank(int numHit, int winningReward) {
    this.numHit = numHit;
    this.winningReward = winningReward;
  }

  public int getNumHit() {
    return this.numHit;
  }

  public int getWinningReward() {
    return this.winningReward;
  }

  public static int calculateTotalReward(Map<Rank, Integer> hitHistory) {
    return Arrays.stream(Rank.values())
        .map(rank -> hitHistory.get(rank) * rank.winningReward)
        .reduce(0, Integer::sum);
  }

  public static Rank getRewardWithBonusBall(int numHit, boolean matchedBonusNumber) {
    if (numHit == 5) {
      return matchedBonusNumber ? Rank.SECOND : Rank.THIRD;
    }

    return getRewardFromNumHit(numHit);
  }

  public static Rank getRewardFromNumHit(int numHit) {
    return Arrays.stream(Rank.values())
        .filter(rank -> rank.numHit == numHit)
        .findAny()
        .orElse(MISS);
  }
}
