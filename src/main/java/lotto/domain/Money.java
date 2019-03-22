package lotto.domain;

import java.util.Objects;

public class Money {

  private final long value;

  public Money(long value) {
    this.value = value;
  }

  public Money sum(Money money) {
    return new Money(this.value + money.value);
  }

  public Money count(long count) {
    return new Money(this.value * count);
  }

  public String division(Money winMoney) {
    return String.format("%.2f", (float)this.value / winMoney.value);
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
    return value == money.value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    return value + "";
  }

  public long amount() {
    return value;
  }
}
