package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

  private final static String LOWER_THAN_LOTTO_PRICE = "500";
  @Test
  @DisplayName("로또 금액보다 작으면 예외를 발생시킨다")
  void throwIfLowerThanLottoPrice() {
    assertThatThrownBy(() -> Money.toLottoPurchasablePrice(Money.from(LOWER_THAN_LOTTO_PRICE)));
  }

  @Test
  @DisplayName("수익률에 대해 계산한다")
  void profitTest() {
    double profit = Math.round(new Money(14000).profit(new Money(5000)) * 100) / 100.0;
    assertThat(profit).isEqualTo(0.36d);
  }
}