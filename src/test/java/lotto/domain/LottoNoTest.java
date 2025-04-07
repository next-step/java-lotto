package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNoTest {

  @Test
  void 로또_번호_생성() {
    int number = 1;
    assertThat(LottoNo.of(number).getNumber()).isEqualTo(number);
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 46})
  void 범위_벗어나면_예외_발생(int number) {
    assertThatThrownBy(() -> LottoNo.of(number))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
  }
}