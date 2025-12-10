package lotto.domain.lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Purchase {

  private final int ticketPrice;
  private final int manualCount;
  private final int autoCount;

  public Purchase(int budget, int ticketPrice, int manualCount) {
    validatePositive(budget, "예산");
    validatePositive(ticketPrice, "티켓 가격");
    validateBudget(budget, ticketPrice);
    int totalCount = budget / ticketPrice;
    validateManualCount(manualCount, totalCount);
    this.ticketPrice = ticketPrice;
    this.manualCount = manualCount;
    this.autoCount = totalCount - manualCount;
  }

  private static void validatePositive(int amount, String name) {
    if (amount < 0) {
      throw new IllegalArgumentException(name + "은 0 이상이어야 합니다");
    }
  }

  private static void validateBudget(int budget, int ticketPrice) {
    if (budget < ticketPrice) {
      throw new IllegalArgumentException("예산이 티켓 가격보다 적습니다");
    }
  }

  private static void validateManualCount(int manualCount, int totalCount) {
    if (manualCount > totalCount) {
      throw new IllegalArgumentException("수동 구매 수가 총 구매 가능 수를 초과합니다");
    }
  }

  public BigDecimal calculateProfitRate(int totalPrize) {
    int spent = getSpentAmount();
    if (spent == 0) {
      throw new IllegalArgumentException("지출 금액이 0입니다");
    }
    return BigDecimal.valueOf(totalPrize)
        .divide(BigDecimal.valueOf(spent), 2, RoundingMode.HALF_UP);
  }

  public int getSpentAmount() {
    return ticketPrice * getTotalCount();
  }

  public int getTotalCount() {
    return manualCount + autoCount;
  }

  public int getAutoCount() {
    return autoCount;
  }

  @Override
  public String toString() {
    return "수동으로 " + manualCount + "장, 자동으로 " + autoCount + "개를 구매했습니다.";
  }
}