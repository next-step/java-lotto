package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

  @Test
  @DisplayName("로또번호를 생성한다.")
  void generate() {
    //given //when
    LottoNumber lottoNumber = LottoNumber.generateManual(45);
    //then
    assertThat(lottoNumber.getNumber()).isBetween(1, 45);
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 46})
  @DisplayName("1보다 작거나 45보다 크면 illegalArgumentsException")
  void generate_fail(int number) {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> LottoNumber.generateManual(number))
        .withMessage("out of bound.");
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 3, 5, 45})
  @DisplayName("선택한 숫자로 로또넘버를 만든다.")
  void generateManual(int number) {
    LottoNumber lottoNumber = LottoNumber.generateManual(number);
    assertEquals(lottoNumber.getNumber(), number);
  }
}