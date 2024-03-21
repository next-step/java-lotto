package domain;

import java.util.Currency;

public class Amount {
  private final PositiveNumber value;
  private final Currency currency;

  public Amount(PositiveNumber value, Currency currency) {
    this.value = value;
    this.currency = currency;
  }

  @Override
  public String toString() {
    return String.format("%s %s", this.currency.getSymbol(), this.value);
  }

}
