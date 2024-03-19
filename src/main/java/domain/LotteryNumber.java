package domain;

import java.util.Objects;

public final class LotteryNumber {
  public static final PositiveNumber LOWER_BOUND = PositiveNumber.of(1);
  public static final PositiveNumber UPPER_BOUND = PositiveNumber.of(45);
  private final PositiveNumber number;

  public static LotteryNumber of(PositiveNumber number) {
    return new LotteryNumber(number);
  }

  public static LotteryNumber of(int number) {
    return new LotteryNumber(new PositiveNumber(number));
  }

  public LotteryNumber(final PositiveNumber number) {
    if (number.lessThan(LOWER_BOUND)) {
      throw new IllegalArgumentException(String.format("Wrong constructor argument! :%s", number));
    }

    if (number.greaterThan(UPPER_BOUND)) {
      throw new IllegalArgumentException(String.format("Wrong constructor argument! :%s", number));
    }
    this.number = number;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LotteryNumber that = (LotteryNumber) o;
    return number.equals(that.number);
  }

  @Override
  public int hashCode() {
    return Objects.hash(number);
  }

  @Override
  public String toString() {
    return this.number.toString();
  }
}
