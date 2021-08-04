package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

  @DisplayName("로또번호 입력 최대값 검증.")
  @ParameterizedTest
  @ValueSource(ints = {46,47,100,1000})
  void 로또한자리최대번호값검증(int input) {
    assertThatThrownBy(
        ()->new LottoNumber(input))
        .isInstanceOf(IllegalArgumentException.class);
  }
}