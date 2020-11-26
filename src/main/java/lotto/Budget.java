package lotto;

import static lotto.LottoGameConstant.NUMBERS_PER_BUNDLE;
import static lotto.LottoGameConstant.PRICE_PER_TICKET;

import lotto.lottoexception.RemainBudgetException;

public class Budget {

  private final String WINNING_MESSAGE = "(축하합니다.)";
  private final String LOOSING_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

  private final int budget;
  private final int initialBudget;
  private int remainBudget;

  private Budget(int initialBudget) {
    this.budget = initialBudget;
    this.initialBudget = initialBudget;
    this.remainBudget = this.initialBudget;
  }

  public static Budget of(int amounts) {
    if (amounts < NUMBERS_PER_BUNDLE) {
      throw new IllegalArgumentException();
    }

    return new Budget(amounts);
  }

  public int getNumPossibleBuyingTicket() {
    return this.budget / PRICE_PER_TICKET;
  }

  public double calculateRatio(int incomes) {
    return (double) incomes / this.initialBudget;
  }

  public String getDescriptiveStatus(int incomes) {
    return calculateRatio(incomes) >= 1 ? WINNING_MESSAGE : LOOSING_MESSAGE;
  }

  public void reduceRemain(int numBuyingTicket) {
    int expectedRemain = this.remainBudget - numBuyingTicket * PRICE_PER_TICKET;
    if (expectedRemain < 0) {
      throw new RemainBudgetException();
    }
    this.remainBudget = expectedRemain;
  }
}
