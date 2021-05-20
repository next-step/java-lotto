package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

  @DisplayName("객체 생성 & 동등성 테스트")
  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3, 5, 10, 45})
  void testConstruct(int given) {
    assertThat(new LottoNumber(given)).isEqualTo(new LottoNumber(given));
  }

  @DisplayName("객체 생성 실패 테스트")
  @ParameterizedTest
  @ValueSource(ints = {Integer.MIN_VALUE, -1, 0, 46, Integer.MAX_VALUE})
  void failTestConstruct(int given) {
    assertThatThrownBy(() -> new LottoNumber(given)).isInstanceOf(IllegalArgumentException.class);
  }

}
