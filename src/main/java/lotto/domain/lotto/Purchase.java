package lotto.domain.lotto;

public class Purchase {

  private final Money pricePerTicket;
  private final int count;

  public Purchase(Money pricePerTicket, int count) {
    this.pricePerTicket = pricePerTicket;
    this.count = count;
  }

  public Money getPurchaseAmount() {
    return pricePerTicket.multiply(count);
  }

  public int getCount() {
    return this.count;
  }
}