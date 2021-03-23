package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

  @ParameterizedTest
  @DisplayName("로또 번호 생성 테스트")
  @ValueSource(ints = {1, 2, 3, 4, 5})
  void create(int value) {
    assertThat(new LottoNumber(value)).isEqualTo(new LottoNumber(value));
  }
}
