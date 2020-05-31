package lotto.step4.domain;

import lotto.step4.execption.InvalidRangeNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoNumberTest {

  @DisplayName("로또 번호의 범위가 1 ~ 45가 아닐 경우 InvalidRangeNumberException 발생")
  @ParameterizedTest
  @ValueSource( ints = { -1, 0, 46 } )
  void 로또_번호_범위_검증 (int lottoNumbers) {
    assertThatExceptionOfType(InvalidRangeNumberException.class)
      .isThrownBy(() -> LottoNumber.valueOf(lottoNumbers));
  }

  @DisplayName("로또 번호의 객체를 재사용 하고 있는지 검사")
  @Test
  void 객체_재사용_검증 () {
    for (int i = LottoNumber.MIN_VALUE; i <= LottoNumber.MAX_VALUE; i++) {
      assertEquals(true, LottoNumber.valueOf(i) == LottoNumber.valueOf(i));
    }
  }
}
