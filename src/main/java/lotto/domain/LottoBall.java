package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public final class LottoBall {
  public static final PositiveNumber LOWER_BOUND = PositiveNumber.of(1);
  public static final PositiveNumber UPPER_BOUND = PositiveNumber.of(45);
  private static final List<LottoBall> CACHE = IntStream.range(LOWER_BOUND.value(), UPPER_BOUND.value() + 1)
          .mapToObj(LottoBall::new)
          .collect(toList());

  private final PositiveNumber number;

  public static LottoBall of(int number) {
    return LottoBall.of(PositiveNumber.of(number));
  }

  public static LottoBall of(PositiveNumber number) {
    if (number.lessThan(LOWER_BOUND)) {
      throw new IllegalArgumentException(String.format("Wrong constructor argument!: %d", number.value()));
    }

    if (number.greaterThan(UPPER_BOUND)) {
      throw new IllegalArgumentException(String.format("Wrong constructor argument!: %s", number.value()));
    }

    return CACHE.get(number.value() - 1);
  }

  private LottoBall(int number) {
    this.number = PositiveNumber.of(number);
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
