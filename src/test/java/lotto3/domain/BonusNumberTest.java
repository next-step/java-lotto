package lotto3.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {

  @ParameterizedTest
  @ValueSource(ints = {0, 46})
  void 보너스숫자가_1과45_범위를_벗어난다고하면_예외검증(int bonusNumber) {
    assertThatThrownBy(() -> new BonusNumber(bonusNumber))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("보너스 볼은 1부터 45까지의 숫자만 가능합니다.");
  }

  @Test
  void 보너스숫자가_당첨번호랑_중복된다면_예외_던지는_검증() {
    BonusNumber bonusNumber = new BonusNumber(1);
    WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));

    assertThatThrownBy(() -> bonusNumber.validateDuplicate(winningNumbers))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("보너스 볼은 당첨 번호와 중복될 수 없습니다.");
  }
}