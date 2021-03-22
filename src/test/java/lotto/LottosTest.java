package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

  @Test
  @DisplayName("금액을 입력받아, 로또 금액으로 나눠 개수를 반환한다.")
  void create() {
    // given
    int money = 14000;
    int expectedSize = money / 1000;

    // when
    Lottos lottos = new Lottos(money);

    // then
    assertThat(lottos.count()).isEqualTo(expectedSize);
  }
}
