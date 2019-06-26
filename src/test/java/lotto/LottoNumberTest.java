package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

  @ParameterizedTest
  @ValueSource(ints = {-1, 46})
  public void 수량은0보다작을수없다(int inputNumber) {
    assertThatThrownBy(() -> {
      new LottoNumber(inputNumber);
    }).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("로또 번호는 1 ~ 45 여야 합니다.");
  }

}