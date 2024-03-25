package lotto.domain;

import java.util.Currency;

public class Amount {
  private final PositiveNumber value;
  private final Currency currency;

  public Amount(PositiveNumber value, Currency currency) {
    this.value = value;
    this.currency = currency;
  }

  public Boolean isPositive() {
    return this.value.greaterThan(PositiveNumber.of(0));
  }

  protected int value() {
    return this.value.value();
  }

  protected Currency currency() {
    return this.currency;
  }

  @Override
  public String toString() {
    return "Amount{" +
            "value='" + this.value + '\'' +
            ", currency='" + this.currency + '\'' +
            "}";
  }

}
