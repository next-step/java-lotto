package lotto;

import static lotto.LottoGameConstant.PRICE_PER_TICKET;

import lotto.lottoexception.IllegalRequestRangeException;
import lotto.lottoexception.RemainBudgetException;

public class Budget {

  private static final String WINNING_MESSAGE = "(축하합니다.)";
  private static final String LOOSING_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

  private final int initialBudget;
  private int afterBuyingManualLotto;

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
    this.afterBuyingManualLotto = calculateAfterRemains(numManualTickets);
  }

  public void validateRequest(int numBuyingTicket) {
    if (calculateAfterRemains(numBuyingTicket) < 0) {
      throw new RemainBudgetException();
    }

    if (numBuyingTicket < 0) {
      throw new IllegalRequestRangeException();
    }
  }

  private int calculateAfterRemains(int numTickets) {
    return this.initialBudget - numTickets * PRICE_PER_TICKET;
  }

  public int getNumPossibleAutoTickets() {
    return this.afterBuyingManualLotto / PRICE_PER_TICKET;
  }

  public int getNumManualTicket() {
    return (this.initialBudget - this.afterBuyingManualLotto) / PRICE_PER_TICKET;
  }

  public int getNumAutoTicket() {
    return this.afterBuyingManualLotto / PRICE_PER_TICKET;
  }

  public double calculateRatio(int incomes) {
    return (double) incomes / this.initialBudget;
  }

  public String getDescriptiveStatus(int incomes) {
    return calculateRatio(incomes) >= 1 ? WINNING_MESSAGE : LOOSING_MESSAGE;
  }
}
