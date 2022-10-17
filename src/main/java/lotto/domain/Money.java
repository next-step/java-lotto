package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Money {

  private static final int LOTTO_PRICE = 1000;
  private final int money;

  private Money(int money) {
    this.money = money;
  }

  public static Money from(int money) {
    if (money < LOTTO_PRICE) {
      throw new IllegalArgumentException("로또의 최소 비용은 1000원 입니다.");
    }
    return new Money(money);
  }

  public int getMoney() {
    return money;
  }

  public int getLottoCount() {
    return money / LOTTO_PRICE;
  }

  public double calYield(long totalPrize) {
    BigDecimal yield = BigDecimal.valueOf(totalPrize).divide(BigDecimal.valueOf(money), 2,
        RoundingMode.DOWN);
    return yield.doubleValue();
  }
}
