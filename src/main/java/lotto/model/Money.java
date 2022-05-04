package lotto.model;

import java.util.Objects;
import lotto.exception.MoneyNumberException;

public final class Money {

  private static final long EMPTY_VALUE = 0L;
  private final long value;

  public Money(long value) {
    validate(value);
    this.value = value;
  }

  private void validate(long value) {
    if (value < EMPTY_VALUE) {
      throw new MoneyNumberException(value);
    }
  }

  public long currentValue() {
    return value;
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

}
