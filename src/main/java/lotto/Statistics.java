package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Statistics {

  private static final int ROUNDING_DIGIT = 100;

  private Lottos purchasedLottos;
  private LastWeekWinLotto lastWeekWinLotto;
  private Rewards rewards;

  public Statistics(Lottos lottos, LastWeekWinLotto lastWeekWinLotto) {
    this.purchasedLottos = lottos;
    this.lastWeekWinLotto = lastWeekWinLotto;
    this.rewards = initReward();
  }

  private Rewards initReward() {
    return new Rewards(rankResult());
  }

  public List<Rank> rankResult() {
    return purchasedLottos.getLottos().stream()
        .map(number -> lastWeekWinLotto.getResult(number))
        .collect(Collectors.toList());
  }

  public double getYield() {
    double income = rewards.totalIncome();
    int expense = getExpense(purchasedLottos.getQuantity());
    return Math.floor((income / expense) * ROUNDING_DIGIT) / ROUNDING_DIGIT;
  }

  private int getExpense(Quantity quantity) {
    return quantity.getValue() * Money.LOTTO_PRICE;
  }

  public Rewards getRewards() {
    return rewards;
  }

}
