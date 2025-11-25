package lotto.domain.lotto;

public class Purchase {

  private final Money pricePerTicket;
  private final LottoTickets tickets;

  public Purchase(Money pricePerTicket, LottoTickets tickets) {
    this.pricePerTicket = pricePerTicket;
    this.tickets = tickets;
  }

  public LottoTickets getTickets(){
    return this.tickets;
  }

  public Money getPurchaseAmount() {
    return tickets.calculate(this.pricePerTicket);
  }

  @Override
  public String toString() {
    return tickets.toString();
  }
}