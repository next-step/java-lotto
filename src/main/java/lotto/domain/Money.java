package lotto.domain;

import java.util.Objects;
import lotto.exception.NegativeMoneyException;

public class Money implements Comparable<Money> {

  private final long value;

  public Money(long value) {
    validateValue(value);
    this.value = value;
  }

  public long value() {
    return value;
  }

  private void validateValue(long value) {
    if (value < 0) {
      throw new NegativeMoneyException();
    }
  }

  @Override
  public int compareTo(Money other) {
    return Long.compare(this.value, other.value);
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
}
