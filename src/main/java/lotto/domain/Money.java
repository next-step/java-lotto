package lotto.domain;

import java.util.Objects;

public class Money {

  private final long amount;

  public static Money from(long amount) {
    return new Money(amount);
  }

  private Money(long amount) {
    if (amount < 0) {
      throw new IllegalArgumentException("돈은 0보다 작을 수 없습니다.");
    }
    this.amount = amount;
  }

  public Money divide(long divisor) {
    return new Money(amount / divisor);
  }

  public long getAmount() {
    return amount;
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

  @Override
  public String toString() {
    return String.valueOf(amount);
  }
}
