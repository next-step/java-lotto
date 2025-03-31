package lotto.domain;

public class PurchaseInfo {
  private final int customerMoney;
  private final int manualLottoCount;

  public PurchaseInfo(int value) {
    this(value, 0);
  }

  public PurchaseInfo(int value, int manualLottoCount) {
    validateCustomerMoney(value);
    this.customerMoney = value;
    validateManualLottoCount(manualLottoCount);
    this.manualLottoCount = manualLottoCount;
  }

  private void validateCustomerMoney(int value) {
    if (value < 0) {
      throw new IllegalArgumentException("0 미만의 금액으로 로또를 구매할 수 없습니다.");
    }
    if (value < Lotto.PRICE) {
      throw new IllegalArgumentException("로또 한 장의 가격보다 적은 금액으로 로또를 구매할 수 없습니다.");
    }
  }

  private void validateManualLottoCount(int manualLottoCount) {
    if (manualLottoCount < 0) {
      throw new IllegalArgumentException("0 미만의 수동 로또 개수로 로또를 구매할 수 없습니다.");
    }

    if (manualLottoCount > calculateTotalLottoCount()) {
      System.out.println("manualLottoCount = " + manualLottoCount);
      System.out.println("calculateTotalLottoCount() = " + calculateTotalLottoCount());
      throw new IllegalArgumentException("수동 로또 개수가 총 로또 개수보다 많습니다.");
    }
  }

  public int calculateTotalLottoCount() {
    return customerMoney / Lotto.PRICE;
  }

  public int getManualLottoCount() {
    return manualLottoCount;
  }

  public int getAutoLottoCount() {
    return calculateTotalLottoCount() - manualLottoCount;
  }

  public double calculateProfitRate(int totalPrizeMoney) {
    return (double) totalPrizeMoney / (Lotto.PRICE * calculateTotalLottoCount());
  }
}
