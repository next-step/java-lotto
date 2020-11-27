package lotto;

import static lotto.LottoGameConstant.PRICE_PER_TICKET;

import lotto.lottoexception.RemainBudgetException;

public class Budget {

  private final String WINNING_MESSAGE = "(축하합니다.)";
  private final String LOOSING_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

  private final int initialBudget;
  private int remainBudget;

  private Budget(int initialBudget) {
    this.initialBudget = initialBudget;
    this.remainBudget = this.initialBudget;
  }

  public static Budget of(int amounts) {
    if (amounts < PRICE_PER_TICKET) {
      throw new RemainBudgetException();
    }

    return new Budget(amounts);
  }

  public int getNumPossibleBuyingTicket() {
    return this.remainBudget / PRICE_PER_TICKET;
  }

  public double calculateRatio(int incomes) {
    return (double) incomes / this.initialBudget;
  }

  public String getDescriptiveStatus(int incomes) {
    return calculateRatio(incomes) >= 1 ? WINNING_MESSAGE : LOOSING_MESSAGE;
  }

  public void reduceRemain(int numBuyingTicket) {
    int remainsAfterBuyingLotto = calculateFutureRemains(numBuyingTicket);
    validateRequestByNumTicket(numBuyingTicket);
    this.remainBudget = remainsAfterBuyingLotto;
  }

  public void validateRequestByNumTicket(int numBuyingTicket) {
    if (calculateFutureRemains(numBuyingTicket) < 0) {
      throw new RemainBudgetException();
    }
  }

  private int calculateFutureRemains(int numTickets) {
    return this.remainBudget - numTickets * PRICE_PER_TICKET;
  }
}
