package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoNoTest {

  @Test
  void 로또_번호_생성() {
    int number = 1;
    assertThat(LottoNo.of(number).getNumber()).isEqualTo(number);
  }

  @ParameterizedTest
  @CsvSource({
      "0, '0는 로또 번호가 될 수 없습니다. 로또 번호는 1부터 45 사이의 숫자여야 합니다.'",
      "46, '46는 로또 번호가 될 수 없습니다. 로또 번호는 1부터 45 사이의 숫자여야 합니다.'"
  })
  void 로또_번호_범위_검증(int number, String expectedMessage) {
    assertThatThrownBy(() -> LottoNo.of(number))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(expectedMessage);
  }
}