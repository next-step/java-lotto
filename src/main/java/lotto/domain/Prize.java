package lotto.domain;

import java.util.Arrays;
import java.util.Currency;
import java.util.Locale;

public enum Prize {
  FIRST(new Condition(6, BonusBallCondition.DONT_CARE), new Amount(PositiveNumber.of(2000000000), Currency.getInstance(Locale.KOREA))),
  SECOND(new Condition(5, BonusBallCondition.TRUE), new Amount(PositiveNumber.of(30000000), Currency.getInstance(Locale.KOREA))),
  THIRD(new Condition(5, BonusBallCondition.FALSE), new Amount(PositiveNumber.of(1500000), Currency.getInstance(Locale.KOREA))),
  FORTH(new Condition(4, BonusBallCondition.DONT_CARE), new Amount(PositiveNumber.of(50000), Currency.getInstance(Locale.KOREA))),
  FIFTH(new Condition(3, BonusBallCondition.DONT_CARE), new Amount(PositiveNumber.of(5000), Currency.getInstance(Locale.KOREA))),
  NONE(new Condition(2, BonusBallCondition.DONT_CARE), new Amount(PositiveNumber.of(0), Currency.getInstance(Locale.KOREA)));

  private final Condition condition;
  private final Amount amount;

  Prize(final Condition condition, final Amount amount) {
    this.condition = condition;
    this.amount = amount;
  }

  public static Prize from(Result result) {
    return Arrays.stream(values())
            .filter(prize -> prize.isPrizeFor(result))
            .findFirst()
            .orElse(Prize.NONE);
  }

  private Boolean isPrizeFor(Result result) {
    return this.condition.accept(result);
  }

  public Boolean isWin() {
    return this.amount.isPositive();
  }

  protected Condition condition() {
    return this.condition;
  }

  protected Amount amount() {
    return this.amount;
  }

  @Override
  public String toString() {
    return "Prize{" +
            "condition='" + this.condition + '\'' +
            ", amount='" + this.amount + '\'' +
            "}";
  }
}
