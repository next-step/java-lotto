package lotto.domain;

import java.util.Objects;

public class Money {

  public static final Money ZERO = Money.of(0);

  private static final String WON_FORMAT = "%d원";

  private final int amount;

  public static Money of(int amount) {
    return new Money(amount);
  }

  private Money(int amount) {
    this.amount = amount;
  }

  public Money multiply(double rate) {
    return new Money((int) (amount * rate));
  }

  public boolean lessThan(Money money) {
    Objects.requireNonNull(money);
    return this.amount < money.amount;
  }

  public Money sum(Money money) {
    Objects.requireNonNull(money);
    return Money.of(amount + money.amount);
  }

  public Money divide(Money money) {
    Objects.requireNonNull(money);
    return Money.of(amount / money.amount);
  }

  public int value() {
    return amount;
  }

  public String won() {
    return String.format(WON_FORMAT, amount);
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
    return Objects.equals(amount, money.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount);
  }

  @Override
  public String toString() {
    return String.format("Money{amount=%d}", amount);
  }
}