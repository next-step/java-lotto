package lotto;

import static lotto.Lotto.LOTTO_NUMBER_COUNT;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

  @Test
  @DisplayName("로또 생성 테스트, 로또가 생성되면 지정된 갯수의 목록을 가진다.")
  void create() {
    // given
    // when
    Lotto lotto = new Lotto();

    // then
    assertThat(lotto.numbers()).hasSize(LOTTO_NUMBER_COUNT);
  }
}
