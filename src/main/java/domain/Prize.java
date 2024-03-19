package domain;

import java.util.Arrays;

public enum Prize {
  FIRST(new Result(PositiveNumber.of(6)), new Amount(PositiveNumber.of(2000000000), Currency.KRW)),
  SECOND(new Result(PositiveNumber.of(5)), new Amount(PositiveNumber.of(1500000), Currency.KRW)),
  THIRD(new Result(PositiveNumber.of(4)), new Amount(PositiveNumber.of(50000), Currency.KRW)),
  FORTH(new Result(PositiveNumber.of(3)), new Amount(PositiveNumber.of(5000), Currency.KRW)),
  NONE(new Result(PositiveNumber.of(2)), new Amount(PositiveNumber.of(0), Currency.KRW));

  private final Result result;
  private final Amount amount;

  Prize(final Result result, final Amount amount) {
    this.result = result;
    this.amount = amount;
  }

  public static Prize of(final Result result) {
    return Arrays.stream(values()).filter(prize -> prize.result.equals(result)).findFirst().orElse(Prize.NONE);
  }

  public Amount amount() {
    return this.amount;
  }
}
