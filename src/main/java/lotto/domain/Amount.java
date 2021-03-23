package lotto.domain;

import lotto.constant.Constant;

public class Amount {

  private int amount;
  private int price;

  public Amount(int price) {
    validate(price);
    this.amount = calculateAmount(price);
    this.price = price;
  }

  public Amount() {
  }

  public void validate(int price) {
    if ((price % Constant.UNIT_OF_DIVISION) > 0) {
      throw new IllegalArgumentException("구입 금액은 " + Constant.UNIT_OF_DIVISION + "원 단위여야 합니다.");
    }
  }

  public int calculateAmount(int price) {
    return price / Constant.UNIT_OF_DIVISION;
  }

  public int getAmount() {
    return amount;
  }

  public int getPrice() {
    return price;
  }
}
