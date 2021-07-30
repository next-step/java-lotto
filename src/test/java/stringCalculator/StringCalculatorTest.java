package stringCalculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

public class StringCalculatorTest {

  @DisplayName("입력값이 null 이거나 빈문자열일 경우 숫자0을 리턴하는 테스트.")
  @ParameterizedTest
  @EmptySource
  @NullSource
  void returnZeroTest(String input) {

    StringCalculator stringCalculator = new StringCalculator(input);

    assertThat(Integer.parseInt(stringCalculator.getText())).isEqualTo(0);
  }

  @DisplayName("입력받은 문자열에서 \",\" 또는 \":을\" 구분자로 자르는 테스트.")
  @Test
  void splitTest() {
    String input = "1,2:3";

    StringCalculator stringCalculator = new StringCalculator(input);
    String[] values = stringCalculator.getSplitValues();

    assertThat(values).containsExactly("1","2","3");
  }

  @DisplayName("특수문자로 나눈 문자열의 합을 리턴하는 테스트.")
  @ParameterizedTest
  @CsvSource(value = {"1,2:3|6","3,3:6|12","2,5:7|14"},delimiter = '|')
  void sumTextTest(String input, int expected) {
    StringCalculator stringCalculator = new StringCalculator(input);
    int result = stringCalculator.getSumValues();

    assertThat(result).isEqualTo(expected);
  }
}
