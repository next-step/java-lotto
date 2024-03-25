package lotto.domain;

public class AmountDto {
  private int value;
  private String currency;

  public AmountDto(Amount amount) {
    this.value = amount.value();
    this.currency = amount.currency().getCurrencyCode();
  }

  public int getValue() {
    return this.value;
  }

  public String getCurrency() {
    return this.currency;
  }
}
