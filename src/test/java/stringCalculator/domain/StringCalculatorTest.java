package stringCalculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StringCalculatorTest {

  @DisplayName("문자열 입력 받으면 합을 계산한다.")
  @ParameterizedTest
  @CsvSource(value = {"1,2,3 6", "1:2:3 6", "1,3,5 9", "8,4,1 13"}, delimiter = ' ')
  void test(String input, String expected) {
    StringCalculator stringCalculator = new StringCalculator();
    assertThat(stringCalculator.calculate(input)).isEqualTo(Integer.parseInt(expected));
  }

}