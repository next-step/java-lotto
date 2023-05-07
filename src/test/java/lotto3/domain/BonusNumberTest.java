package lotto3.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {

  @ParameterizedTest
  @ValueSource(ints = {0, 46})
  void 보너스숫자가_1과45_범위를_벗어난다고하면_예외검증(int bonusNumber) {
    assertThatThrownBy(() -> new LottoNumber(bonusNumber))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("로또 번호는 1부터 45까지의 숫자만 가능합니다.");
  }

}