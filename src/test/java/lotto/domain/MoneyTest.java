package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

  @Test
  @DisplayName("로또 구매 금액을 입력하면 구매가능한 로또 장수를 반환한다.")
  void givenMoney_ShouldBeLottoCount() {
    assertThat(Money.from(9100).countLotto()).isEqualTo(9);
  }

  @Test
  @DisplayName("당첨 금액과 구매 금액을 넣으면 수익률을 반환한다.")
  void givenTotalPrize_ShouldBeRateOfReturn() {
    assertThat(Money.from(14000).rateOfReturn(Money.from(5000))).isEqualTo(0.35d);
  }

}