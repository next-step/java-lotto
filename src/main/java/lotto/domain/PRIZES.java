package lotto.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum PRIZES {
  FIRST(6, 2_000_000_000, (count, bonus) -> count == 6),
  SECOND(5, 30_000_000, (count, bonus) -> count == 5 && bonus),
  THIRD(5, 1_500_000, (count, bonus) -> count == 5 && !bonus),
  FOURTH(4, 50_000, (count, bonus) -> count == 4),
  FIFTH(3, 5_000, (count, bonus) -> count == 3),
  MISS(0, 0, (count, bonus) -> count < 3);

  private int winningsNumber;
  private int winningMoney;
  private final BiPredicate<Integer, Boolean> matchCondition;

  PRIZES(int winningsNumber, int winningMoney, BiPredicate<Integer, Boolean> matchCondition) {
    this.winningsNumber = winningsNumber;
    this.winningMoney = winningMoney;
    this.matchCondition = matchCondition;
  }

  public static PRIZES valueOf(int count, boolean matchBonus) {
    return Arrays.stream(values())
        .filter(prize -> prize.matchCondition.test(count, matchBonus))
        .findFirst()
        .orElse(MISS);
  }

  public long calculatePrizeAmount(Integer value) {
    return (long) winningMoney * value;
  }
}
