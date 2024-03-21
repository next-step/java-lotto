package domain;

import java.util.Arrays;
import java.util.Currency;
import java.util.Locale;

public enum Prize {
  FIRST(new Result(PositiveNumber.of(6)), new Amount(PositiveNumber.of(2000000000), Currency.getInstance(Locale.KOREA))),
  SECOND(new Result(PositiveNumber.of(5)), new Amount(PositiveNumber.of(1500000), Currency.getInstance(Locale.KOREA))),
  THIRD(new Result(PositiveNumber.of(4)), new Amount(PositiveNumber.of(50000), Currency.getInstance(Locale.KOREA))),
  FORTH(new Result(PositiveNumber.of(3)), new Amount(PositiveNumber.of(5000), Currency.getInstance(Locale.KOREA))),
  NONE(new Result(PositiveNumber.of(2)), new Amount(PositiveNumber.of(0), Currency.getInstance(Locale.KOREA)));

  private final Result result;
  private final Amount amount;

  Prize(final Result result, final Amount amount) {
    this.result = result;
    this.amount = amount;
  }

  public static Prize of(final Result result) {
    return Arrays.stream(values())
            .filter(prize -> prize.resultEquals(result))
            .findFirst()
            .orElse(Prize.NONE);
  }

  public Amount amount() {
    return this.amount;
  }

  public boolean resultEquals(final Result result) {
    return this.result.equals(result);
  }
}
