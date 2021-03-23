package lotto.domain;

import java.util.Objects;

public final class Money {

  private final int money;

  public Money(int money) {
    this.money = money;
  }

  public Money divideBy(Money price) {
    return new Money(this.money / price.money);
  }

  public int toInteger() {
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
