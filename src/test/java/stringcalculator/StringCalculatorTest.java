package stringcalculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StringCalculatorTest {

  @ParameterizedTest
  @CsvSource({",", "' '", "null"})
  @DisplayName("입력_문자열의_숫자와_사칙_연산_사이에는_반드시_빈_공백_문자열이_있다")
  void testInvalidInput(String input) {
    StringCalculator stringCalculator = new StringCalculator();
    assertThatThrownBy(() -> {
      stringCalculator.calculateString(input);
    }).isInstanceOf(IllegalArgumentException.class);

  }

  @Test
  void 덧셈() {
    StringCalculator stringCalculator = new StringCalculator();
    assertEquals(3, stringCalculator.calculateString("1 + 2"));
  }
}