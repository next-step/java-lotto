package stringCalculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

  @DisplayName("입력받은 문자열에서 \",\" 또는 \":을\" 구분자로 자르는 테스트.")
  @Test
  void splitTest() {
    String input = "1,2:3";

    StringCalculator stringCalculator = new StringCalculator(input);
    String[] values = stringCalculator.getSplitValues();

    assertThat(values).containsExactly("1","2","3");
  }
}
