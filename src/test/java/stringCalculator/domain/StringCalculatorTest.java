package stringCalculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {

  @DisplayName("문자열 입력 받으면 합을 계산한다.")
  @Test
  void test() {
    StringCalculator stringCalculator = new StringCalculator();
    int result = stringCalculator.calculate("1,2,3");
    assertThat(result).isEqualTo(6);
  }

}