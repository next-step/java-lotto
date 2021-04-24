package study.step2.domain;

import java.util.Objects;

public class LottoPrice {

  private static final int LOTTO_PRICE = 1000;

  private final int money;

  public LottoPrice(int money) {
    this.money = money;
  }

  public int lottoCount() {
    return this.money / LOTTO_PRICE;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LottoPrice that = (LottoPrice) o;
    return money == that.money;
  }

  @Override
  public int hashCode() {
    return Objects.hash(money);
  }
}
