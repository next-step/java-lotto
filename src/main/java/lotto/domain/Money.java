package lotto.domain;

import java.util.Objects;

public class Money {
  private final int amount;

  public Money(int amount) {
    this.amount = amount;
  }

  public int getPurchasableTicketCount() {
    return amount / LottoTicket.TICKET_PRICE;
  }

  public int getAmount() {
    return amount;
  }

  public Money difference(Money other) {
    return new Money(amount - other.getAmount());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Money money = (Money) o;
    return amount == money.amount;
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount);
  }
}
