package lotto;

import static lotto.LottoGameConstant.doesntCareBonus;
import static lotto.LottoGameConstant.mustWithBonus;
import static lotto.LottoGameConstant.mustWithoutBonus;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;

public enum Rank {
  FIRST(6, 2_000_000_000, doesntCareBonus),
  SECOND(5, 30_000_000, mustWithBonus),
  THIRD(5, 1_500_000, mustWithoutBonus),
  FOURTH(4, 50_000, doesntCareBonus),
  FIFTH(3, 5_000, doesntCareBonus),
  MISS(0, 0, doesntCareBonus);


  private final Function<Boolean, Boolean> isEffectedByBonus;
  private final int numHit;
  private final int winningReward;

  Rank(int numHit, int winningReward, Function<Boolean, Boolean> isEffectedByBonus) {
    this.numHit = numHit;
    this.winningReward = winningReward;
    this.isEffectedByBonus = isEffectedByBonus;
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
    return Arrays.stream(Rank.values())
        .filter(rank -> rank.numHit == numHit)
        .filter(rank -> rank.isEffectedByBonus.apply(matchedBonusNumber))
        .findAny()
        .orElse(MISS);
  }
}
