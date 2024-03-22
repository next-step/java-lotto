package domain;

import java.util.stream.IntStream;

public class Lottery {
  private final LottoBalls normalBalls;
  private final LottoBall bonusBall;

  static public Lottery of(final LottoBall bonusBall, final LottoBalls normalBalls) {
    return new Lottery(bonusBall, normalBalls);
  }

  private Lottery(final LottoBall bonusBall, final LottoBalls normalBalls) {
    this.normalBalls = normalBalls;
    this.bonusBall = bonusBall;
  }

  public PositiveNumber matchCount(LottoBalls target) {
    int count = IntStream.range(0, this.normalBalls.size().value())
            .reduce(0, (acc, cur) -> {
              if (this.normalBalls.match(PositiveNumber.of(cur), target)) {
                return ++acc;
              }
              return acc;
            });
    return PositiveNumber.of(count);
  }

  public Boolean bonusMatched(LottoBall bonusBall) {
    return this.bonusBall.equals(bonusBall);
  }
}
