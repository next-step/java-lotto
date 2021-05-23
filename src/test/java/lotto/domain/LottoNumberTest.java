package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

  @DisplayName("로또 숫자는 1 ~ 45의 값을 가져야만 한다.")
  @ParameterizedTest
  @ValueSource(ints = {Integer.MIN_VALUE, -1, 0, 46, Integer.MAX_VALUE})
  void failTestConstruct(int given) {
    assertThatThrownBy(() -> new LottoNumber(given)).isInstanceOf(IllegalArgumentException.class);
  }

}
