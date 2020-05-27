package lotto.step3.domain;

import lotto.step3.execption.InvalidRangeNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoNumberTest {

  @DisplayName("로또 번호의 범위가 1 ~ 45가 아닐 경우 InvalidRangeNumberException 발생")
  @ParameterizedTest
  @ValueSource( ints = { -1, 0, 46 } )
  void 로또_번호_범위_검증 (int lottoNumbers) {
    assertThatExceptionOfType(InvalidRangeNumberException.class)
      .isThrownBy(() -> LottoNumber.of(lottoNumbers));
  }
}
