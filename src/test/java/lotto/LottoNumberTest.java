package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import lotto.lottoexception.IllegalLottoNumberRange;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

  @ParameterizedTest
  @ValueSource(ints = {1, 45})
  @DisplayName("로또 생성")
  void createNumber(int input) {
    assertThat(LottoNumber.of(input)).isEqualTo(LottoNumber.of(input));
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 46})
  @DisplayName("허용되지 않은 범위에서의 생성 테스트")
  void outOfRangeInstance(int input) {
    assertThatExceptionOfType(IllegalLottoNumberRange.class)
        .isThrownBy(
            () -> LottoNumber.of(input)
        );
  }

  @Test
  @DisplayName("비교 연산자 테스트")
  void compareLessThan() {
    assertThat(LottoNumber.of(1)).isLessThan(LottoNumber.of(2));
  }

  @Test
  @DisplayName("비교 연산자 테스트(같은 값)")
  void compareLessThanOrEqual() {
    assertThat(LottoNumber.of(1)).isLessThanOrEqualTo(LottoNumber.of(1));
  }
}
