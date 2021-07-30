package stringCalculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
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
}
