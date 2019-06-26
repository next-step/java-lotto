package lotto;

public class Money {

  public static final int LOTTO_PRICE = 1000;
  private int money;

  public Money(int money) {
    validate(money);
    this.money = money;
  }

  private void validate(int money) {
    isGreaterThanZero(money);
    isGreaterThanLottoPrice(money);
  }

  private void isGreaterThanZero(int money) {
    if (money < 0) {
      throw new IllegalArgumentException("금액은 0보다 커야 합니다.");
    }
  }

  private void isGreaterThanLottoPrice(int money) {
    if (money < LOTTO_PRICE) {
      throw new IllegalArgumentException("로또를 살 수 없습니다.");
    }
  }

  public int getAvailableQuantity() {
    return money / LOTTO_PRICE;
  }

}
