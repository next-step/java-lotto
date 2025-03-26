package lotto.domain;

public class PurchaseAmount {
  private final int customerMoney;

  public PurchaseAmount(int value) {
    validate(value);
    this.customerMoney = value;
  }

  private void validate(int value) {
    if (value < 0) {
      throw new IllegalArgumentException("0 미만의 금액으로 로또를 구매할 수 없습니다.");
    }
    if (value < Lotto.PRICE) {
      throw new IllegalArgumentException("로또 한 장의 가격보다 적은 금액으로 로또를 구매할 수 없습니다.");
    }
  }

  public int calculateLottoCount() {
    return customerMoney / Lotto.PRICE;
  }

  public double calculateProfitRate(int totalPrizeMoney) {
    return (double) totalPrizeMoney / (Lotto.PRICE * calculateLottoCount());
  }
}
