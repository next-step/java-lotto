package lotto.domain.entity;

public class Budget {

  private static final String INVALID_BUDGET = "구매할 수 없는 금액입니다.";
  private static final int ZERO = 0;

  private int cost;

  public Budget(int cost) {
    if (cost <= 0) {
      throw new IllegalArgumentException(INVALID_BUDGET);
    }
    this.cost = cost;
  }

  public void minusBudget(int cost) {
    if (this.cost >= cost) {
      this.cost -= cost;
    }
  }

  public boolean isEmpty() {
    return this.cost <= ZERO;
  }
}
