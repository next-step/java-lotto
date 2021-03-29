package step2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step2.domain.number.Number;
import step2.exception.InvalidLottoNumberException;

class NumberTest {
  @ParameterizedTest
  @DisplayName("로또 번호로 1이하의 값이 들어올 때의 테스트")
  @ValueSource(ints = {0,-1,-5})
  void underMinLimitTest(int number){
    Assertions.assertThatThrownBy(
      () -> new Number(number)
    ).isInstanceOf(InvalidLottoNumberException.class)
      .hasMessage("로또의 최소 번호는 1입니다.");
  }

  @ParameterizedTest
  @DisplayName("로또 번호로 45이상의 값이 들어올 때의 테스트")
  @ValueSource(ints = {46,47,50})
  void overMaxLimitTest(int number){
    Assertions.assertThatThrownBy(
      () -> new Number(number)
    ).isInstanceOf(InvalidLottoNumberException.class)
      .hasMessage("로또의 최대 번호는 45입니다.");
  }

  @ParameterizedTest
  @DisplayName("1 ~ 45의 값이 들어올 때의 테스트")
  @ValueSource(ints = {1,5,12,21,27,33,42,45})
  void normalNumberTest(int number){
    Assertions.assertThat(new Number(number).toString()).isEqualTo(String.valueOf(number));
  }
}