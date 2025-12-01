package lotto;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

  @DisplayName("당첨 번호와 보너스 번호가 중복되면 예외가 발생한다")
  @Test
  void duplicateWinningNumbers() {
    Lotto winningNumbers = new Lotto("1,2,3,4,5,6");
    LottoNumber bonus = new LottoNumber(6);
    assertThatIllegalArgumentException().isThrownBy(() -> new WinningNumbers(winningNumbers, bonus))
        .withMessageContaining("중복");
  }

}