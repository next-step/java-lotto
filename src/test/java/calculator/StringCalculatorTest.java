package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

  @DisplayName("숫자하나만 입력")
  @Test
  public void splitAndSumOneNumber() {
    int result = StringCalculator.splitAndSum("1");
    assertThat(result).isEqualTo(1);
  }

  @DisplayName("쉼표 구분자로 입력")
  @Test
  public void splitAndSumComma() {
    int result = StringCalculator.splitAndSum("1, 2, 3");
    assertThat(result).isEqualTo(6);
  }

  @DisplayName("쉼표와 콜론 구분자로 입력")
  @Test
  public void splitAndSum_comma_colon() {
    int result = StringCalculator.splitAndSum("1:2,3");
    assertThat(result).isEqualTo(6);
  }
}
