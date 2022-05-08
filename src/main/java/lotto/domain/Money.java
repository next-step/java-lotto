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
    return String.format(WON_FORMAT, amount);
  }

  public Money multiply(double rate) {
    return new Money((int) (amount * rate));
  }

  public boolean lessThan(int money) {
    return this.amount < money;
  }

  public int divide(int pricePerPlayForLotto) {
    return this.amount / pricePerPlayForLotto;
  }
}