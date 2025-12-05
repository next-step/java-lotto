package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

  @DisplayName("당첨 번호와 보너스 번호가 중복되면 예외가 발생한다")
  @Test
  void duplicateWinningNumbers() {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> new WinningNumbers("1,2,3,4,5,6", 6))
        .withMessageContaining("중복");
  }

  @Test
  void containsWinningNumber() {
    WinningNumbers wn = new WinningNumbers("1,2,3,4,5,6", 7);
    assertThat(wn.contains(3)).isTrue();
    assertThat(wn.contains(7)).isFalse();
  }

  @Test
  void hasBonusNumber() {
    WinningNumbers wn = new WinningNumbers("1,2,3,4,5,6", 7);
    assertThat(wn.hasBonus(7)).isTrue();
    assertThat(wn.hasBonus(3)).isFalse();
  }
}
