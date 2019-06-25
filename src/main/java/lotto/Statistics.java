package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Statistics {

  private static final int ROUNDING_DIGIT = 100;

  private Lottos purchasedLottos;
  private Lotto lastWeekWinLotto;
  private Rewards rewards;

  public Statistics(Lottos lottos, Lotto lastWeekWinLotto) {
    this.purchasedLottos = lottos;
    this.lastWeekWinLotto = lastWeekWinLotto;
    this.rewards = initReward();
  }

  private Rewards initReward() {
    return new Rewards(Arrays.stream(PrizeInformation.values())
        .map(prizeInfo ->
            new Reward(prizeInfo, getSameNumberCount(prizeInfo.getBoundaryCount())))
        .collect(Collectors.toList()));
  }

  private int getSameNumberCount(int boundaryCount) {
    return purchasedLottos.getSameNumberCount(lastWeekWinLotto, boundaryCount);
  }

  public double getYield() {
    double income = rewards.getIncome();
    int expense = getExpense(purchasedLottos.getQuantity());
    return Math.floor((income / expense) * ROUNDING_DIGIT) / ROUNDING_DIGIT;
  }

  private int getExpense(Quantity quantity) {
    return quantity.getValue() * Money.LOTTO_PRICE;
  }

  public List<Reward> getRewards() {
    return rewards.getRewards();
  }

}
