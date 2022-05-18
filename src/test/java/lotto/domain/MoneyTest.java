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

}