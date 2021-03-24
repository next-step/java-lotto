package lotto.domain;

public class Money {

  private int money;

  public Money(int money) {
    checkMoney(money);
    this.money = money;
  }

  private void checkMoney(int money) {
    if (money < 0) {
      throw new IllegalArgumentException("Money should always be greater than 0.");
    }
  }

  public int getBuyableCount() {
    checkPurchaseLotto(money);
    return money / 1000;
  }

  private void checkPurchaseLotto(int money) {
    if (money % 1000 != 0) {
      throw new IllegalArgumentException("money is over or less.");
    }
  }
}
