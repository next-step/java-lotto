package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.IllegalWinningLottoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

  Lotto lastWinningLotto;

  @BeforeEach
  void setUp() {
    lastWinningLotto = new Lotto(new String[]{"1", "2", "3", "4", "5", "6"});
  }

  @Test
  @DisplayName("우승 번호와 보너스 번호를 입력받아 지난주 당첨 번호를 관리하는 클래스를 생성한다.")
  void create() {
    // given
    LottoNumber bonusNumber = LottoNumber.valueOf("7");

    // when
    // then
    assertThat(new WinningLotto(lastWinningLotto, bonusNumber))
        .isEqualTo(new WinningLotto(lastWinningLotto, bonusNumber));
  }

  @Test
  @DisplayName("우승 번호에 보너스 번호가 포함되어 있으면 실패해야 한다.")
  void createFail() {
    // given
    LottoNumber bonusNumber = LottoNumber.valueOf("6");

    // when
    // then
    assertThatThrownBy(() -> new WinningLotto(lastWinningLotto, bonusNumber))
        .isInstanceOf(IllegalWinningLottoException.class)
        .hasMessage(IllegalWinningLottoException.WINNING_NUMBER_CANNOT_CONTAIN_BONUS_NUMBER);
  }
}
