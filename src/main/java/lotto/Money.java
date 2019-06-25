package lotto;

public class Money {

  public static final int LOTTO_PRICE = 1000;
  private int money;

  public Money(int money) {
    if (money < 0) {
      throw new IllegalArgumentException("금액은 0보다 커야 합니다.");
    }
    this.money = money;
  }

  public int getAvailableQuantity() {
    return money / LOTTO_PRICE;
  }

}
