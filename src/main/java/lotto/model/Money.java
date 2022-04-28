package lotto.model;

import java.util.Objects;
import lotto.exception.MoneyNegativeException;

public final class Money {

  private final Integer value;

  public Money() {
    this(0);
  }

  public Money(Integer value) {
    valid(value);
    this.value = value;
  }

  private void valid(Integer value) {
    if(value < 0) {
      throw new MoneyNegativeException();
    }
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
    return Objects.equals(value, money.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    return value.toString();
  }
}
