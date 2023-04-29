package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {
  @ParameterizedTest
  @ValueSource(ints = {-1, 0, 46, 47})
  void 로또_번호가_1부터_45까지의_숫자에_포함되지_않으면_IllegalArgumentException이_발생한다(int input) {
    assertThatThrownBy(() -> LottoNumber.from(input))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("로또 번호는 1~45 사이의 숫자여야 합니다.");
  }

  @Test
  void 숫자를_반환한다() {
    int number = 5;
    LottoNumber lottoNumber = LottoNumber.from(number);
    assertThat(lottoNumber.getNumber())
        .isEqualTo(number);
  }
}
