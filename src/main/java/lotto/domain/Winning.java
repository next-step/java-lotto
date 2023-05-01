package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum Winning {
  FIRST(6, 2000000000),
  SECOND(5, 1500000),
  THIRD(4, 50000),
  FOURTH(3, 5000),
  NONE(0, 0);

  private int sameCount;
  private int reward;

  Winning(int sameCount, int reward) {
    this.sameCount = sameCount;
    this.reward = reward;
  }

  public static Map<Winning, Integer> score(LottoTickets lottoTickets, List<LottoNumber> lastWeekNumbers) {
    List<Integer> sameCounts = lottoTickets.sameCounts(lastWeekNumbers);

    Map<Winning, Integer> scores = new HashMap();

    Arrays.stream(Winning.values())
        .forEach(winning -> scores.put(winning, 0));

    for (int sameCount : sameCounts) {
      Winning winning = Arrays.stream(Winning.values())
          .filter(win -> win.sameCount == sameCount)
          .findFirst()
          .orElse(NONE);

      scores.put(winning, scores.get(winning) + 1);
    }

    return scores;
  }

  public static double profit(Map<Winning, Integer> winnings, Money lottoPurchasablePrice) {
    int totalPrice = 0;

    for (Winning winning : winnings.keySet()) {
      totalPrice += winnings.get(winning) * winning.reward;
    }

    return lottoPurchasablePrice.profit(new Money(totalPrice));
  }

  public int sameCount() {
    return this.sameCount;
  }

  public int reward() {
    return this.reward;
  }
}
