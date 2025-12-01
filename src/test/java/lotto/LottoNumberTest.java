package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

  @DisplayName("로또 번호는 1~45 사이의 숫자다")
  @ParameterizedTest
  @ValueSource(ints = {1, 10, 45})
  void createLottoNumber(int number) {
    LottoNumber lottoNumber = new LottoNumber(number);
    assertThat(lottoNumber.number()).isEqualTo(number);
  }

  @DisplayName("로또 번호가 1~45 가 아닌 경우 예외가 발생한다")
  @ParameterizedTest
  @ValueSource(ints = {0, 46})
  void invalidLottoNumber(int number) {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> new LottoNumber(number))
        .withMessageContaining("1~45");
  }
}
