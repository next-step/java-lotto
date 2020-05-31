package lotto.collections;

public final class Money {

  private final int money;

  public Money(int money) {
    this.money = money;
  }

  public int getNumberOfPurchasedLotto() {
    final double TICKET_PRICE = 1000;
    return (int) (money / TICKET_PRICE);
  }

  public int getMoney() {
    return money;
  }
}
