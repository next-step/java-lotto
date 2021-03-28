package lotto.domain;

import lotto.constant.Constant;

public class Amount {

  private int autoAmount;
  private int price;
  private int manualAmount;

  public Amount(int price, int manualAmount) {
    validate(price, manualAmount);
    this.autoAmount = calculateAutoAmount(price, manualAmount);
    this.price = price;
    this.manualAmount = manualAmount;
  }

  public Amount() {
  }

  public void validate(int price, int manualAmount) {
    if ((price % Constant.UNIT_OF_DIVISION) > 0) {
      throw new IllegalArgumentException("구입 금액은 " + Constant.UNIT_OF_DIVISION + "원 단위여야 합니다.");
    }

    if ((price % Constant.UNIT_OF_DIVISION) < manualAmount) {
      throw new IllegalArgumentException("수동 구매 수량은 전체 구입 수량보다 클 수 없습니다.");
    }
  }

  public int calculateAutoAmount(int price, int manualAmount) {
    return (price / Constant.UNIT_OF_DIVISION) - manualAmount;
  }

  public int getAutoAmount() {
    return autoAmount;
  }

  public int getManualAmount() {
    return manualAmount;
  }

  public int getPrice() {
    return price;
  }
}
