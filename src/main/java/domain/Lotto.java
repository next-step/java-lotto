package domain;

import java.util.List;

public class Lotto {
  private static final PositiveNumber PRICE = PositiveNumber.of(1000);
  public static final PositiveNumber NUMBER_COUNT = PositiveNumber.of(6);

  private final LottoBalls balls;

  public Lotto(final LottoBalls balls) {
    if (!balls.sizeOf(NUMBER_COUNT)) {
      throw new IllegalArgumentException("Wrong number of balls!");
    }
    this.balls = balls;
  }

  static public Lotto of(final List<LottoBall> balls) {
    return new Lotto(new LottoBalls(balls));
  }

  static public Lotto of(final LottoBalls balls) {
    return new Lotto(balls);
  }

  static public Lotto of(final LottoBall... balls) {
    return new Lotto(LottoBalls.of(balls));
  }

  static public Lotto of(final int... balls) {
    return new Lotto(LottoBalls.of(balls));
  }

  public static PositiveNumber count(final PositiveNumber amount) {
    return amount.quotient(PRICE);
  }

  public Result result(final LottoBalls balls) {
    return Result.of(this.balls.matchCount(balls));
  }

  @Override
  public String toString() {
    return this.balls.toString();
  }
}
