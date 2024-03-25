package lotto.domain;

import java.util.List;

public class Lotto {
  private static final PositiveNumber PRICE = PositiveNumber.of(1000);
  public static final int NORMAL_BALLS_COUNT = 6;
  public static final int BONUS_BALL_COUNT = 1;

  private final LottoBalls normalBalls;
  private final LottoBall bonusBall;

  static public Lotto of(final LottoBall bonusBall, final List<LottoBall> normalBalls) {
    return new Lotto(bonusBall, LottoBalls.of(normalBalls));
  }

  static public Lotto of(final LottoBall bonusBall, final LottoBalls normalBalls) {
    return new Lotto(bonusBall, normalBalls);
  }

  static public Lotto of(final LottoBall bonusBall, final LottoBall... normalBalls) {
    return new Lotto(bonusBall, LottoBalls.of(normalBalls));
  }

  static public Lotto of(final int bonusBall, final int... normalBalls) {
    return new Lotto(LottoBall.of(bonusBall), LottoBalls.of(normalBalls));
  }

  private Lotto(final LottoBall bonusBall, final LottoBalls normalBalls) {
    if (!normalBalls.sizeOf(NORMAL_BALLS_COUNT)) {
      throw new IllegalArgumentException("Wrong number of normal balls!");
    }

    this.bonusBall = bonusBall;
    this.normalBalls = normalBalls;
  }

  public static PositiveNumber count(final PositiveNumber amount) {
    return amount.quotient(PRICE);
  }

  public Result result(final Lottery lottery) {
    return Result.of(lottery.matchCount(this.normalBalls), lottery.bonusMatched(this.bonusBall));
  }

  public LottoBalls normalBalls() {
    return this.normalBalls;
  }

  public LottoBall bonusBall() {
    return this.bonusBall;
  }

  @Override
  public String toString() {
    return "Lotto{" +
            "normalBall='" + this.normalBalls + '\'' +
            ", bonusBall='" + this.bonusBall + '\'' +
            "}";
  }
}
