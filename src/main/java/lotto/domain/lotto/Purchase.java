package lotto.domain.lotto;

public class Purchase {

  private final Money budget;
  private final Money ticketPrice;
  private final int manualCount;
  private final int autoCount;

  public Purchase(Money budget, Money ticketPrice, int manualCount) {
    validateBudget(budget, ticketPrice);
    int totalCount = budget.countUnits(ticketPrice);
    validateManualCount(manualCount, totalCount);
    this.budget = budget;
    this.ticketPrice = ticketPrice;
    this.manualCount = manualCount;
    this.autoCount = totalCount - manualCount;
  }

  private static void validateBudget(Money budget, Money ticketPrice) {
    if (budget.isLessThan(ticketPrice)) {
      throw new IllegalArgumentException("예산이 티켓 가격보다 적습니다");
    }
  }

  private static void validateManualCount(int manualCount, int totalCount) {
    if (manualCount > totalCount) {
      throw new IllegalArgumentException("수동 구매 수가 총 구매 가능 수를 초과합니다");
    }
  }

  public Money getSpentAmount() {
    return ticketPrice.multiply(manualCount + autoCount);
  }


  public int getAutoCount() {
    return autoCount;
  }

  @Override
  public String toString() {
    return "수동으로 " + manualCount + "장, 자동으로 " + autoCount + "개를 구매했습니다.";
  }
}