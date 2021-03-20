package lotto.domain;

public class Pay {

  private int money;

  public Pay(int money) {
    checkMoney(money);
    checkPurchaseLotto(money);
    this.money = money;
  }

  private void checkPurchaseLotto(int money) {
    if (money % 1000 != 0) {
      throw new IllegalArgumentException("money is over or less.");
    }
  }

  private void checkMoney(int money) {
    if (money < 0) {
      throw new IllegalArgumentException("Money should always be greater than 0.");
    }
  }
}
