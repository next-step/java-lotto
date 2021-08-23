package lotto.domain;

import java.util.Objects;

public class Money implements Comparable<Money> {

  private final long value;

  public Money(long value) {
    checkValue(value);
    this.value = value;
  }

  public long value() {
    return value;
  }

  private void checkValue(long value) {
    if (value < 0) {
      throw new IllegalArgumentException("돈은 음수가 될 수 없습니다.");
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
