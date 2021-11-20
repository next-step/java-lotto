package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

  @Test
  @DisplayName("입력값으로 0또는 null이 주어질 경우 0을 반환한다.")
  void splitAndSum_null_또는_빈문자() {
    int result = StringAddCalculator.splitAndSum(null);
    assertThat(result).isEqualTo(0);

    result = StringAddCalculator.splitAndSum("");
    assertThat(result).isEqualTo(0);
  }

  @ParameterizedTest
  @ValueSource(strings = "1")
  void splitAndSum_숫자하나(String value) throws Exception {
    int result = StringAddCalculator.splitAndSum(value);
    assertThat(result).isEqualTo(1);
  }

  @ParameterizedTest
  @ValueSource(strings = {"1,2"})
  void splitAndSum_쉼표구분자(String value) throws Exception {
    int result = StringAddCalculator.splitAndSum(value);
    assertThat(result).isEqualTo(3);
  }

  @ParameterizedTest
  @ValueSource(strings = {"1,2:3"})
  void splitAndSum_쉼표_또는_콜론_구분자(String value) throws Exception {
    int result = StringAddCalculator.splitAndSum(value);
    assertThat(result).isEqualTo(6);
  }

  @ParameterizedTest
  @ValueSource(strings = {"//;\n1;2;3"})
  @DisplayName("커스텀 구분자로 ;를 사용하여 계산한다. 결과값은 6이다.")
  void splitAndSum_custom_구분자(String value) throws Exception {
    int result = StringAddCalculator.splitAndSum(value);
    assertThat(result).isEqualTo(6);
  }

  @ParameterizedTest
  @ValueSource(strings = {"-1,2,3"})
  @DisplayName("문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.")
  void splitAndSum_negative(String value) throws Exception {
    assertThatThrownBy(() -> StringAddCalculator.splitAndSum(value))
            .isInstanceOf(RuntimeException.class);
  }

}
