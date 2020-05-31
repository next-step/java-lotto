package lotto.collections;

public final class Money {

  private final int money;

  public Money(int money) {
    this.money = validateMoneyRange(money);
  }

  private int validateMoneyRange(int money) {
    if (money < 1000) {
      throw new RuntimeException("money input is wrong.");
    }
    return money;
  }

  public int getNumberOfPurchasedLotto() {
    final double TICKET_PRICE = 1000;
    return (int) (money / TICKET_PRICE);
  }

  public int getMoney() {
    return money;
  }
}
