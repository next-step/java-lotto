package lotto.domain;

import java.util.Objects;

public class Money implements Comparable<Money> {
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
    if (this.compareTo(other) < 0) {
      throw new IllegalArgumentException("현재 가진 돈보다 더 많은 돈을 사용할 수 없습니다.");
    }
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

  @Override
  public int compareTo(Money o) {
    return Integer.compare(getAmount(), o.getAmount());
  }
}
