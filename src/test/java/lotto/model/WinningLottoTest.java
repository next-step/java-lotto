package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.LottoNumberDuplicateException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

  @Test
  @DisplayName("입력된 지난주 로또번호들의 갯수는 6개이다")
  void checkNumberOfGeneratedLottoNumbers() {
    // given
    WinningLotto lottoNumbers = WinningLotto.create("1, 2, 3, 4, 5, 6");

    // then
    assertThat(lottoNumbers.getWinningLottoNumbers()).hasSize(6);
  }

  @Test
  @DisplayName("중복된 로또 번호가 존재한다면 예외처리를 한다")
  void exceptionDuplicateLottoNumbers() {
    // when & then
    assertThatThrownBy(() -> WinningLotto.create("1, 1, 1, 1, 1, 1"))
        .isInstanceOf(LottoNumberDuplicateException.class);
  }
}