package lotto;

public class LottoMachine {

  public LottoTickets buy(Money money) {
    return LottoTickets.issue(money.ticketPurchasableNumber());
  }
}
