package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LastWinningNumberTest {

  @Test
  @DisplayName("우승 번호와 보너스 번호를 입력받아 지난주 당첨 번호를 관리하는 클래스를 생성한다.")
  void create() {
    // given
    Lotto lastWinningLotto = new Lotto(new String[]{"1", "2", "3", "4", "5", "6"});
    LottoNumber bonusNumber = LottoNumber.valueOf("7");

    // when
    // then
    assertThat(new LastWinningNumber(lastWinningLotto, bonusNumber))
        .isEqualTo(new LastWinningNumber(lastWinningLotto, bonusNumber));
  }
}
