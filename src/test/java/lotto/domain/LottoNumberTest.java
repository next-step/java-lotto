package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

  @Test
  @DisplayName("로또번호를 생성한다.")
  void generate() {
    //given //when
    LottoNumber lottoNumber = new LottoNumber(45);
    //then
    assertAll(
        () -> assertTrue(lottoNumber.getNumber() > 0),
        () -> assertTrue(lottoNumber.getNumber() < 46)
    );
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 46})
  @DisplayName("1보다 작거나 45보다 크면 illegalArgumentsException")
  void generate_fail(int number) {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> new LottoNumber(number))
        .withMessage("out of bound.");
  }
}