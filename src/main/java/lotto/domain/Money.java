package lotto.domain;

import java.util.Objects;

public class Money {

  private static final int LOTTO_PRICE = 1000;

  private int value;
  public Money(int value) {
    this.value = value;
  }

  public static Money from(String userMoney) {
    try {
      return new Money(Integer.parseInt(userMoney));
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("금액에는 숫자만 들어올 수 있습니다. 입력된 금액 : " + userMoney);
    }
  }

  public static Money toLottoPurchasablePrice(Money userMoney) {
    if (userMoney.value < LOTTO_PRICE) {
      throw new IllegalArgumentException(String.format("최소 %d원을 입력해야 로또를 구입할 수 있습니다. 입력한 금액 : %s", LOTTO_PRICE, userMoney));
    }

    return new Money(userMoney.value - (userMoney.value % LOTTO_PRICE));
  }

  public Money subtraction(Money target) {
    return new Money(this.value - target.value);
  }

  public int ticketPurchasableNumber() {
    return this.value / LOTTO_PRICE;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Money money = (Money) o;
    return this.value == money.value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.value);
  }

  @Override
  public String toString() {
    return Integer.toString(this.value);
  }

  public double profit(Money other) {
        return (double) other.value / this.value;
  }
}