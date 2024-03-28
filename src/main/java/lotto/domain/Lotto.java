package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Lotto {
  private static final PositiveNumber PRICE = PositiveNumber.of(1000);
  public static final int LOTTO_BALLS_COUNT = 6;

  private final LottoBalls lottoBalls;

  static public Lotto of(final List<LottoBall> lottoBalls) {
    return new Lotto(LottoBalls.of(lottoBalls));
  }

  static public Lotto of(final LottoBalls lottoBalls) {
    return new Lotto(lottoBalls);
  }

  static public Lotto of(final LottoBall... lottoBalls) {
    return new Lotto(LottoBalls.of(lottoBalls));
  }

  static public Lotto of(final int... lottoBalls) {
    return new Lotto(LottoBalls.of(lottoBalls));
  }

  static public Lotto of(final String text) {
    return Lotto.of(text.replace(" ", "").split(","));
  }

  static public Lotto of(final String[] values) {
    return Lotto.of(Arrays.stream(values).mapToInt(Integer::parseInt).toArray());
  }

  private Lotto(final LottoBalls lottoBalls) {
    if (!lottoBalls.sizeOf(LOTTO_BALLS_COUNT)) {
      throw new IllegalArgumentException("Wrong number of balls!");
    }

    this.lottoBalls = lottoBalls;
  }

  public static PositiveNumber count(final PositiveNumber amount) {
    return amount.quotient(PRICE);
  }

  public Result result(final Lottery lottery) {
    return Result.of(lottery.matchCount(this.lottoBalls), lottery.bonusMatched(this.lottoBalls));
  }

  public LottoBalls lottoBalls() {
    return this.lottoBalls;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Lotto lotto = (Lotto) o;
    return lottoBalls.equals(lotto.lottoBalls);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lottoBalls);
  }

  @Override
  public String toString() {
    return "Lotto{" +
            "Balls='" + this.lottoBalls + '\'' +
            "}";
  }
}
