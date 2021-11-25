package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

  @Test
  @DisplayName("로또번호의 최소값 보다 작은 로또 번호는 올 수 없음을 검증하는 테스트")
  void lottoNumberCanNotHaveLowerNumberThanMinNumber() {
    // given
    int lowerNumberThanMinNumber = LottoNumber.MIN_NUMBER - 1;

    // then
    assertThatThrownBy(() -> {
      // when
      new LottoNumber(lowerNumberThanMinNumber);
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @ParameterizedTest
  @ValueSource(ints = {0, -1})
  @DisplayName("로또번호의 최대값 보다 큰 로또 번호는 올 수 없음을 검증하는 테스트")
  void lottoNumberCanNotHaveHigherNumberThanMaxNumber(int input) {
    // given
    int higherNumberThanMaxNumber = LottoNumber.MAX_NUMBER + 1;

    // then
    assertThatThrownBy(() -> {
      // when
      new LottoNumber(higherNumberThanMaxNumber);
    }).isInstanceOf(IllegalArgumentException.class);
  }

}
