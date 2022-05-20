package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

  @Test
  @DisplayName("로또 번호 생성")
  void givenNumber_ShouldBeCratedLottoNumber() {
    assertThat(LottoNumber.from("1")).isEqualTo(LottoNumber.from(1));
    assertThat(LottoNumber.from("1") == LottoNumber.from(1)).isTrue();
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 46})
  @DisplayName("로또 번호 범위에서 벗어나는 값 예외")
  void givenNonLottoNumber_ShouldException(int value) {
    assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.from(value));
  }
}