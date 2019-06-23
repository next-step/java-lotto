package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Statistics {

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

  public Rewards getRewards() {
    return rewards;
  }

  int getSameNumberCount(int boundaryCount) {
    List<Lotto> purchasedLotto = purchasedLottos.getPurchasedLotto();
    return (int) purchasedLotto.stream()
        .map(lotto -> lotto.countSameNumber(lastWeekWinLotto))
        .filter(value -> value == boundaryCount)
        .count();
  }

  public double getYield() {
    double income = rewards.getIncome();
    int expense = getExpense(purchasedLottos.getQuantity());
    return Math.floor((income/expense) * 100) / 100.0;
  }

  private int getExpense(Quantity quantity) {
    return quantity.getValue() * Money.LOTTO_PRICE;
  }

}
