package lotto.domain;

import java.util.Objects;

public class PurchaseAmount {

  private static final int PRICE_PER_TICKET = 1000;
  public static final String INVALID_PURCHASE_AMOUNT_INPUT = "해당 금액으로는 로또 구매가 불가능합니다. 금액을 다시 확인해주세요. input: %s";

  private final int amount;

  public PurchaseAmount(int amount) {
    validate(amount);
    this.amount = amount;
  }

  public boolean isSame(int amount) {
    return this.amount == amount;
  }

  private void validate(int amount) {

    if (amount <= 0 || amount % PRICE_PER_TICKET != 0) {
      throw new IllegalArgumentException(String.format(INVALID_PURCHASE_AMOUNT_INPUT, amount));
    }
  }

  public int ticketCount() {
    return this.amount / PRICE_PER_TICKET;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    PurchaseAmount that = (PurchaseAmount) o;
    return amount == that.amount;
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount);
  }
}
