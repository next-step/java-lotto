package lotto;

import static lotto.LottoGameConstant.PRICE_PER_TICKET;

import lotto.lottoexception.RemainBudgetException;

public class Budget {

  private final String WINNING_MESSAGE = "(축하합니다.)";
  private final String LOOSING_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

  private final int initialBudget;
  private int remains;

  private Budget(int initialBudget) {
    this.initialBudget = initialBudget;
    this.remains = this.initialBudget;
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
    if (this.remains < PRICE_PER_TICKET) {
      throw new RemainBudgetException();
    }

    this.remains -= numTicket * PRICE_PER_TICKET;
    return TicketPublisher.publishTickets(numTicket);
  }

  public double calculateRatio(int incomes) {
    return (double) incomes / this.initialBudget;
  }

  public String getDescriptiveStatus(int incomes) {
    return calculateRatio(incomes) >= 1 ? WINNING_MESSAGE : LOOSING_MESSAGE;
  }
}
