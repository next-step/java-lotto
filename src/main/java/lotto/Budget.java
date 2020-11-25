package lotto;

import static lotto.LottoGameConstant.PRICE_PER_TICKET;

public class Budget {

  private final String WINNING_MESSAGE = "(축하합니다.)";
  private final String LOOSING_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

  private final int budget;

  private Budget(int initialBudget) {
    this.budget = initialBudget;
  }

  public static Budget of(int amounts) {
    if (amounts < 0) {
      throw new IllegalArgumentException();
    }

    return new Budget(amounts);
  }

  public int getNumPossibleLotto() {
    return this.budget / PRICE_PER_TICKET;
  }

  public double calculateRatio(int incomes) {
    return (double) incomes / this.budget;
  }

  public String getDescriptiveStatus(int incomes) {
    return calculateRatio(incomes) >= 1 ? WINNING_MESSAGE : LOOSING_MESSAGE;
  }
}
