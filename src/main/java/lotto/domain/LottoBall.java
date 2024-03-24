package lotto.domain;

import java.util.Objects;

public final class LottoBall {
  public static final PositiveNumber LOWER_BOUND = PositiveNumber.of(1);
  public static final PositiveNumber UPPER_BOUND = PositiveNumber.of(45);
  private final PositiveNumber number;

  public static LottoBall of(PositiveNumber number) {
    return new LottoBall(number);
  }

  public static LottoBall of(int number) {
    return new LottoBall(PositiveNumber.of(number));
  }

  public LottoBall(final PositiveNumber number) {
    if (number.lessThan(LOWER_BOUND)) {
      throw new IllegalArgumentException(String.format("Wrong constructor argument!: %d", number.value()));
    }

    if (number.greaterThan(UPPER_BOUND)) {
      throw new IllegalArgumentException(String.format("Wrong constructor argument!: %s", number.value()));
    }
    this.number = number;
  }

  public PositiveNumber number() {
    return this.number;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LottoBall that = (LottoBall) o;
    return number.equals(that.number);
  }

  @Override
  public int hashCode() {
    return Objects.hash(number);
  }

  @Override
  public String toString() {
    return "LottoBall{" +
            "number='" + this.number + '\'' +
            "}";
  }
}
