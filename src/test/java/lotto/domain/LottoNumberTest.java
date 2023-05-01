package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

  @ParameterizedTest
  @ValueSource(ints = {-1, 0, 46})
  @DisplayName("Number의 범위를 벗어나면 예외를 발생시킨다")
  void lottoNumberBoundaryExceptionTest(int number) {
    assertThatThrownBy(() -> LottoNumber.from(String.valueOf(number)))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(String.format("숫자는 %d ~ %d 사이의 값만 들어올 수 있습니다.", LottoNumbers.LOTTO_NUMBER_INBOUND, LottoNumbers.LOTTO_NUMBER_OUTBOUND));
  }
}
