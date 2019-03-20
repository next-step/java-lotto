package lotto.domain;

import java.util.Objects;

public class Money {

  private long value;

  public Money(long value) {
    this.value = value;
  }

  void sum(Money money) {
    this.value += money.value;
  }

  Money count(long winCount) {
    this.value *= winCount;
    return this;
  }

  String division(Money winMoney) {
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

  long amount() {
    return value;
  }
}
