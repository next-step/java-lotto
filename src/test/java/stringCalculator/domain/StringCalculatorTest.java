package stringCalculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StringCalculatorTest {

  private StringCalculator stringCalculator;

  @BeforeEach
  void setUp() {
    stringCalculator = new StringCalculator();
  }

  @DisplayName("문자열 입력 받으면 합을 계산한다.")
  @ParameterizedTest
  @CsvSource(value = {"1,2,3 6", "1:2:3 6", "1,3,5 9", "8,4,1 13"}, delimiter = ' ')
  void calculate(String input, String expected) {
    assertThat(stringCalculator.calculate(input)).isEqualTo(Integer.parseInt(expected));
  }

  @DisplayName("커스텀 문자열 합 계산")
  @Test
  void custom_delimeter() {
    assertThat(stringCalculator.calculate("//!\n1!7!9")).isEqualTo(17);
  }

}