package lotto.view;

import lotto.domain.Money;

public class StatisticsDto {

  private int count;
  private Money price;

  public StatisticsDto(int count, Money price) {
    this.count = count;
    this.price = price;
  }

  public int getCount() {
    return count;
  }

  public Money getPrice() {
    return price;
  }
}
