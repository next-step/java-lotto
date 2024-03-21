package domain;

import java.util.List;

public class Lotto {
  private static final PositiveNumber PRICE = PositiveNumber.of(1000);
  private static final PositiveNumber NORMAL_BALLS_COUNT = PositiveNumber.of(6);
  private static final PositiveNumber BONUS_BALL_COUNT = PositiveNumber.of(1);
  public static final PositiveNumber TOTAL_BALLS_COUNT = NORMAL_BALLS_COUNT.sum(BONUS_BALL_COUNT);

  private final LottoBalls normalBalls;
  private final LottoBall bonusBall;

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

  public Lotto(final LottoBalls balls) {
    if (!balls.sizeOf(TOTAL_BALLS_COUNT)) {
      throw new IllegalArgumentException("Wrong number of balls!");
    }
    this.normalBalls = balls.subList(PositiveNumber.of(0), NORMAL_BALLS_COUNT);
    this.bonusBall = balls.lastBall();
  }

  public static PositiveNumber count(final PositiveNumber amount) {
    return amount.quotient(PRICE);
  }

  public Result result(final LottoBalls balls) {
    PositiveNumber matchCount = this.normalBalls.matchCount(balls.subList(PositiveNumber.of(0), balls.size()));
    return Result.of(matchCount, this.bonusBall.equals(balls.lastBall()));
  }

  @Override
  public String toString() {
    return String.format("%s, 보너스 번호: %s", this.normalBalls.toString(), this.bonusBall);
  }
}
