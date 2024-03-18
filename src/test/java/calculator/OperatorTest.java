package calculator;

import calculator.domain.type.StringOperator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static calculator.domain.type.StringOperator.THIS_OPERATOR_IS_NOT_SUPPORTED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperatorTest {
  @ParameterizedTest
  @ValueSource(strings = {"!", "?", "$", "#"})
  @DisplayName("사칙 연산이 불가능한 입력 값인 경우 IllegalArgumentException throw")
  void operatorTest(String given) {
    assertThatThrownBy(() -> StringOperator.convert(given))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(String.format(THIS_OPERATOR_IS_NOT_SUPPORTED, given));
  }

  @ParameterizedTest
  @CsvSource(value = {
      "+:ADDITION",
      "-:SUBTRACTION",
      "*:MULTIPLICATION",
      "/:DIVISION"
  }, delimiter = ':')
  @DisplayName("입력 값으로 들어온 사칙연산 기호를 x순서대로 저장하는지 테스트")
  void operatorTest2(String given, StringOperator expected) {
    assertThat(StringOperator.convert(given)).isEqualTo(expected);
  }
}
