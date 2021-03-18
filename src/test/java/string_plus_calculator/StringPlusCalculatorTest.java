package string_plus_calculator;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StringPlusCalculatorTest {

  @Test
  @DisplayName("null 또는 공백 문자열 입력 시, 0을 리턴한다.")
  void null_blank_return_zero() {
    //given
    StringPlusCalculator stringPlusCalculator = new StringPlusCalculator(null);
    //when
    int result = stringPlusCalculator.calculate();
    //then
    assertEquals(result, 0);
  }

  @Test
  @DisplayName("null 또는 공백 문자열 입력 시, 0을 리턴한다.")
  void blank_return_zero() {
    //given
    StringPlusCalculator stringPlusCalculator = new StringPlusCalculator("");
    //when
    int result = stringPlusCalculator.calculate();
    //then
    assertEquals(result, 0);
  }

  @ParameterizedTest
  @CsvSource(value = {"1,1", "12,12", "123,123"})
  @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
  void only_number(String input, int expected) {
    //given
    StringPlusCalculator stringPlusCalculator = new StringPlusCalculator(input);
    //when
    int result = stringPlusCalculator.calculate();
    //then
    assertEquals(result, expected);
  }

  @ParameterizedTest
  @CsvSource(delimiter = '|', value = {"1,2|3", "2,3|5"})
  @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다")
  void comma_split_number(String input, int expected) {
    //given
    StringPlusCalculator stringPlusCalculator = new StringPlusCalculator(input);
    //when
    int result = stringPlusCalculator.calculate();
    //then
    assertEquals(result, expected);
  }
  
  @ParameterizedTest
  @CsvSource(delimiter = '|', value = {"1:2|3", "2:3|5"})
  @DisplayName("구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다.")
  void colon_split_number(String input, int expected) {
    //given
    StringPlusCalculator stringPlusCalculator = new StringPlusCalculator(input);
    //when
    int result = stringPlusCalculator.calculate();
    //then
    assertEquals(result, expected);
  }

  @ParameterizedTest
  @CsvSource(delimiter = '|', value = {"//;\r1;2;3|6", "///\r1/2/3|6"})
  @DisplayName("“//”와 “\n” 문자 사이에 커스텀 구분자를 지정할 수 있다.")
  void custom_delimiter(String input, int expected) {
    //given
    StringPlusCalculator stringPlusCalculator = new StringPlusCalculator(input);
    //when
    int result = stringPlusCalculator.calculate();
    //then
    assertEquals(result, expected);
  }

  @Test
  @DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생해야 한다.")
  void minus_number_exception() {
    //given
    StringPlusCalculator stringPlusCalculator = new StringPlusCalculator("-1");
    //when
    //then
    assertThatExceptionOfType(RuntimeException.class)
        .isThrownBy(() -> stringPlusCalculator.calculate())
        .withMessage("minus number is invalid.");
  }
}