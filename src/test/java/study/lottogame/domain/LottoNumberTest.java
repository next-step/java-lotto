package study.lottogame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

  @DisplayName("로또번호는 1~45 범위를 넘으면 Exception을 던진다.")
  @ParameterizedTest
  @ValueSource(ints = {0, -1, -10, 46, 100})
  public void LottoNumber_throwException_outOfBound(int input) {
    assertThatThrownBy(() -> LottoNumber.valueOf(input))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("로또번호가 같다면 동일한 객체이다.")
  @ParameterizedTest
  @ValueSource(ints = {1, 5, 10, 40, 45})
  public void valueOf_identicalLottoNumber(int input) {
    assertThat(LottoNumber.valueOf(input) == (LottoNumber.valueOf(input))).isTrue();
  }
}
