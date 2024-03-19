package domain;

import java.util.List;

public class Lottery {
  private static final PositiveNumber PRICE = PositiveNumber.of(1000);
  public static final PositiveNumber NUMBER_COUNT = PositiveNumber.of(6);

  private final LotteryNumbers numbers;

  public Lottery(final LotteryNumbers numbers) {
    if (!numbers.sizeOf(NUMBER_COUNT)) {
      throw new IllegalArgumentException("Wrong number of lottery numbers!");
    }
    this.numbers = numbers;
  }

  static public Lottery of(final List<LotteryNumber> numbers) {
    return new Lottery(new LotteryNumbers(numbers));
  }

  static public Lottery of(final LotteryNumbers numbers) {
    return new Lottery(numbers);
  }

  static public Lottery of(final LotteryNumber... numbers) {
    return new Lottery(LotteryNumbers.of(numbers));
  }

  static public Lottery of(final int... numbers) {
    return new Lottery(LotteryNumbers.of(numbers));
  }

  public static PositiveNumber count(final PositiveNumber amount) {
    return amount.quotient(PRICE);
  }

  public Result result(final LotteryNumbers numbers) {
    return Result.of(this.numbers.matchCount(numbers));
  }

  @Override
  public String toString() {
    return this.numbers.toString();
  }
}
