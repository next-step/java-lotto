package lotto.domain;

public class Money {

  private final int money;
  private static final int COST_CRETERION = 1000;
  private static final String INVALID_COST = "구매 금액은 1000원 이상이어야 합니다.";

  public Money(final int money) {
    validateMoney(money);
    this.money = money;
  }

  public void validateMoney(int money) {
    if (money < COST_CRETERION) {
      throw new IllegalArgumentException(INVALID_COST);
    }
  }

  public int calculateLottoCount() {
    return (money / COST_CRETERION);
  }
}
