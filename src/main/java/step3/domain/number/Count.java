package step3.domain.number;

import step3.exception.InvalidCountNumberException;

import java.util.Objects;

public class Count {
  private static final String UNDER_COUNT_MIN_LIMIT = "회수의 최소 숫자는 0입니다.";
  final int number;

  public Count() {
    this(0);
  }

  public Count(int number) {
    if (number < 0) {
      throw new InvalidCountNumberException(UNDER_COUNT_MIN_LIMIT);
    }
    this.number = number;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Count count = (Count) o;
    return number == count.number;
  }

  public int showCount() {
    return number;
  }

  public Count addCount(Count operand) {
    return new Count(number + operand.number);
  }

  @Override
  public int hashCode() {
    return Objects.hash(number);
  }

  @Override
  public String toString() {
    return String.valueOf(number);
  }
}
