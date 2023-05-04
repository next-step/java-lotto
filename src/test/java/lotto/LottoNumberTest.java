package lotto;

import lotto.domain.number.LottoNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

  @ParameterizedTest(name = "LottoNumber | 로또번호는 0 또는 음수 일 수 없다. 번호: {0}")
  @ValueSource(ints = {-2, -1 , 0})
  void 로또번호는_음수_일_수_없다 (int given) {
    // when & then
    Assertions.assertThatThrownBy(() -> new LottoNumber(given))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
