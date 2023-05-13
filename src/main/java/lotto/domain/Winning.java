package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum Winning {
  FIRST(6, 2000000000),
  SECOND(5, 30000000),
  THIRD(5, 1500000),
  FOURTH(4, 50000),
  FIVE(3, 5000),
  NONE(0, 0);

  private int sameCount;
  private int reward;

  Winning(int sameCount, int reward) {
    this.sameCount = sameCount;
    this.reward = reward;
  }

  public static double profit(Map<Winning, Integer> winnings, Money lottoPurchasablePrice) {
    int totalPrice = 0;

    for (Winning winning : winnings.keySet()) {
      totalPrice += winnings.get(winning) * winning.reward;
    }

    return lottoPurchasablePrice.profit(new Money(totalPrice));
  }

  public static Winning of(int sameCount, boolean isIncludesBonusNumber) {

    Winning winning = Arrays.stream(Winning.values())
        .filter(win -> win.sameCount == sameCount)
        .findFirst()
        .orElse(NONE);

    if (winning == SECOND && !isIncludesBonusNumber) {
      return THIRD;
    }

    return winning;
  }

  public int sameCount() {
    return this.sameCount;
  }

  public int reward() {
    return this.reward;
  }
}
