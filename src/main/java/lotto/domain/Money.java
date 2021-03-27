package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class Money {

  private final int money;

  public Money(final int money) {
    if (money < 0) {
      throw new IllegalArgumentException("입력한 돈이 음수입니다.");
    }
    this.money = money;
  }

  public int calculateTryLottoCount(Integer lottoPrice) {
    return this.money / lottoPrice;
  }

  public Money multiply(int count) {
    return new Money(this.money * count);
  }

  public Money plus(Money money) {
    return new Money(this.money + money.money);
  }

  public double calculateRate(Money investMoney) {
    return new BigDecimal(this.money)
        .divide(new BigDecimal(investMoney.money) , 2, RoundingMode.HALF_UP)
        .doubleValue()
        ;
  }
}
