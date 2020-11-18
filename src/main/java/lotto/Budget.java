package lotto;

import static lotto.LottoGameConstant.PRICE_PER_TICKET;

public class Budget {

  int amounts;

  private Budget(int amounts) {
    this.amounts = amounts;
  }

  public static Budget of(int amounts) {
    if (amounts < 0) {
      throw new IllegalArgumentException();
    }

    return new Budget(amounts);
  }

  public int getNumPossibleLotto() {
    return this.amounts / PRICE_PER_TICKET;
  }

  public LottoTickets purchaseLotto(int numTicket) {
    if (amounts < PRICE_PER_TICKET) {
      throw new IllegalArgumentException();
    }

    amounts -= numTicket * PRICE_PER_TICKET;
    return NumberPool.purchaseTickets(numTicket);
  }
}
