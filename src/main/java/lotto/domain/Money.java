package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public final class Money {

  private final int money;

  public Money(final int money) {
    if (money < 0) {
      throw new IllegalArgumentException("입력한 돈이 0보다 작습니다.");
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
        .divide(new BigDecimal(investMoney.money), 2, RoundingMode.HALF_UP)
        .doubleValue()
        ;
  }

  public boolean availableBuyLotto() {
    return this.money >= 1000;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Money money1 = (Money) o;
    return money == money1.money;
  }

  @Override
  public int hashCode() {
    return Objects.hash(money);
  }
}
