package lotto.domain;

import java.util.Objects;
import lotto.exception.NegativeMoneyException;

public final class Money {

  private final long money;

  public Money(int money) {
    this((long) money);
  }

  public Money(long money) {
    validateNegativeMoney(money);
    this.money = money;
  }

  private void validateNegativeMoney(long money) {
    if (money < 0) {
      throw new NegativeMoneyException();
    }
  }

  public Money divideBy(Money otherMoney) {
    return new Money(money / otherMoney.money);
  }

  public Money sum(Money otherMoney) {
    return new Money(money + otherMoney.money);
  }

  public Money multiply(int multiplier) {
    return multiply((long) multiplier);
  }

  public Money multiply(long multiplier) {
    return new Money(money * multiplier);
  }

  public long toInteger() {
    return money;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Money)) {
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
