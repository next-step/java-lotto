package lotto;

import static lotto.LottoGameConstant.PRICE_PER_TICKET;

import lotto.lottoexception.IllegalRequestRangeException;
import lotto.lottoexception.RemainBudgetException;

public class Budget {

  private static final String WINNING_MESSAGE = "(축하합니다.)";
  private static final String LOOSING_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

  private final int initialBudget;
  private int remains;

  private Budget(int initialBudget) {
    this.initialBudget = initialBudget;
  }

  public static Budget of(int amounts) {
    if (amounts < PRICE_PER_TICKET) {
      throw new RemainBudgetException();
    }
    return new Budget(amounts);
  }

  public void buyManualTickets(int numManualTickets) {
    // 검증하기
    validateRequest(numManualTickets);
    this.remains = calculateRemains(numManualTickets);
  }

  public void validateRequest(int numBuyingTicket) {
    if (calculateRemains(numBuyingTicket) < 0) {
      throw new RemainBudgetException();
    }

    if (numBuyingTicket < 0) {
      throw new IllegalRequestRangeException();
    }
  }

  private int calculateRemains(int numTickets) {
    return this.remains - numTickets * PRICE_PER_TICKET;
  }

  public int getNumPossibleAutoTickets() {
    return this.remains / PRICE_PER_TICKET;
  }

  public int getNumManualTicket() {
    return (this.initialBudget - this.remains) / PRICE_PER_TICKET;
  }

  public int getNumAutoTicket() {
    return this.remains / PRICE_PER_TICKET;
  }

  public double calculateRatio(int incomes) {
    return (double) incomes / this.initialBudget;
  }

  public String getDescriptiveStatus(int incomes) {
    return calculateRatio(incomes) >= 1 ? WINNING_MESSAGE : LOOSING_MESSAGE;
  }
}
