package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

  @DisplayName("1과 45 사이의 값이 아닌 수로 LottoNumber를 생성하려 하면 예외가 발생한다.")
  @ParameterizedTest
  @ValueSource(ints = {0, 46})
  void create_invalid_number(int input) {
    assertThatThrownBy(() -> LottoNumber.of(input)).isInstanceOf(IllegalArgumentException.class);
  }
}
