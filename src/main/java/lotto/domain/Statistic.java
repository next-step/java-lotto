package lotto.domain;

import lotto.domain.money.Money;

public class Statistic {

  private final Prizes prizes;
  private final int matchedPrizeCount;

  public Statistic(int matchedPriceCount, Prizes prizes) {
    this.matchedPrizeCount = matchedPriceCount;
    this.prizes = prizes;
  }

  public int getMatchedPrizeCount() {
    return matchedPrizeCount;
  }

  public int getMatchCount() {
    return prizes.getMatchCount();
  }

  public Money getPrizeMoney() {
    return prizes.getPrize();
  }

  public Money getTotalPrize() {
    return getPrizeMoney().multiply(getMatchedPrizeCount());
  }
}
