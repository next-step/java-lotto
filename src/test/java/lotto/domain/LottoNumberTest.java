package lotto.domain;

import static lotto.domain.LottoNumber.ILLEGAL_LOTTO_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

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

  @ParameterizedTest
  @DisplayName("로또 번호 생성 실패 테스트")
  @ValueSource(ints = {0, 46})
  void createFail(int value) {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> new LottoNumber(value))
        .withMessage(ILLEGAL_LOTTO_NUMBER);
  }
}
