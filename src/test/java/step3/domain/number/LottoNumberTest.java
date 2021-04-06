package step3.domain.number;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step3.exception.InvalidLottoNumberException;

class LottoNumberTest {
  @ParameterizedTest
  @DisplayName("로또 번호로 1이하의 값이 들어올 때의 테스트")
  @ValueSource(ints = {0, -1, -5})
  void underMinLimitTest(int number) {
    Assertions.assertThatThrownBy(
      () -> new LottoNumber(number)
    ).isInstanceOf(InvalidLottoNumberException.class)
      .hasMessage("로또의 최소 번호는 1입니다." + number);
  }

  @ParameterizedTest
  @DisplayName("로또 번호로 45이상의 값이 들어올 때의 테스트")
  @ValueSource(ints = {46, 47, 50})
  void overMaxLimitTest(int number) {
    Assertions.assertThatThrownBy(
      () -> new LottoNumber(number)
    ).isInstanceOf(InvalidLottoNumberException.class)
      .hasMessage("로또의 최대 번호는 45입니다." + number);
  }

  @ParameterizedTest
  @DisplayName("1 ~ 45의 값이 들어올 때의 테스트")
  @ValueSource(ints = {1, 5, 12, 21, 27, 33, 42, 45})
  void normalNumberTest(int number) {
    Assertions.assertThat(new LottoNumber(number).toString()).isEqualTo(String.valueOf(number));
  }

  @ParameterizedTest
  @DisplayName("두 로또 숫자의 비교 결과 테스트")
  @CsvSource(value = {"1;2;-1", "45;1;1", "2;2;0"}, delimiter = ';')
  void compareTest(int sourceNumber, int targetNumber, int result) {
    Assertions.assertThat(new LottoNumber(sourceNumber).compareTo(new LottoNumber(targetNumber))).isEqualTo(result);
  }
}