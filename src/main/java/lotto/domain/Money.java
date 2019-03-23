package lotto.domain;

import java.util.Objects;

public class Money {

  private final long amount;

  public Money(long amount) {
    this.amount = amount;
  }

  public Money sum(Money money) {
    return new Money(this.amount + money.amount);
  }

  public int buy(long productAmount) {

    if (this.amount < productAmount) {
      throw new IllegalArgumentException();
    }

    return (int)(this.amount / productAmount);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Money money = (Money) o;
    return amount == money.amount;
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount);
  }
}
