package lotto;

import static lotto.LottoGameConstant.PRICE_PER_TICKET;

public class Budget {

  private final int amounts;
  private int remains;

  private Budget(int amounts) {
    this.amounts = amounts;
    this.remains = this.amounts;
  }

  public static Budget of(int amounts) {
    if (amounts < 0) {
      throw new IllegalArgumentException();
    }

    return new Budget(amounts);
  }

  public int getNumPossibleLotto() {
    return this.remains / PRICE_PER_TICKET;
  }

  public LottoTickets purchaseLotto(int numTicket) {
    if (remains < PRICE_PER_TICKET) {
      throw new IllegalArgumentException();
    }

    remains -= numTicket * PRICE_PER_TICKET;
    return NumberPool.purchaseTickets(numTicket);
  }

  public double calculateRatio(int benefit) {
    return (double) benefit / this.amounts;
  }
}
