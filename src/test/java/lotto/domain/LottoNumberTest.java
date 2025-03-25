package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {
  @Test
  @DisplayName("로또 번호가 MIN_NUMBER와 MAX_NUMBER 사이가 아닐 경우 IllegalArgumentException 예외를 발생시킨다.")
  void invalidLottoNumber() {
    assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(0));
    assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(46));
  }

}
