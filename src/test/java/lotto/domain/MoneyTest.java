package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

  @Test
  @DisplayName("1000원 미만일 경우 IllegalArgumentException이 발생하는지 확인한다.")
  void createMoneyTest() {

    //given
    int money = 900;
    //when
    //then
    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> Money.from(money));
  }

  @Test
  @DisplayName("수익률 계산을 확인한다.")
  void calYieldTest() {

    int payMoney = 10000;
    int totalPrize = 5000;

    Money money = Money.from(payMoney);

    assertThat(money.calYield(totalPrize)).isEqualTo(0.50);
  }
}