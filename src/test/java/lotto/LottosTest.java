package lotto;

import static lotto.Lottos.PRICE;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

  @Test
  @DisplayName("금액을 입력받아, 로또 금액으로 나눠 개수를 반환한다.")
  void create() {
    // given
    Money money = new Money(14000);
    int expectedSize = money.divideBy(PRICE).toInteger();

    // when
    Lottos lottos = new Lottos(money);

    // then
    assertThat(lottos.count()).isEqualTo(expectedSize);
  }
}
