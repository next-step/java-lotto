package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.RepeatedTest.LONG_DISPLAY_NAME;

class LottoNumberTest {

  @DisplayName("로또 번호는 1~45 숫자중 랜덤 숫자를 반환한다.")
  @RepeatedTest(value = 1_000, name = LONG_DISPLAY_NAME)
  void generate() {
    // given
    LottoNumber lottoNumber = LottoNumber.generate();

    // when
    boolean actual = lottoNumber.isValidNumberRange();

    // then
    assertThat(actual).isTrue();
  }
}
