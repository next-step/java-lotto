package calculator;

import calculator.domain.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static calculator.domain.Operator.THIS_OPERATOR_IS_NOT_SUPPORTED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperatorTest {
  @ParameterizedTest
  @ValueSource(strings = {"!", "?", "$", "#"})
  @DisplayName("사칙 연산이 불가능한 입력 값인 경우 IllegalArgumentException throw")
  void operatorTest(String given) {
    assertThatThrownBy(() -> Operator.isOperator(given))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(String.format(THIS_OPERATOR_IS_NOT_SUPPORTED, given));
  }

  @ParameterizedTest
  @ValueSource(strings = {"+", "-", "*", "/"})
  @DisplayName("입력 값으로 들어온 사칙연산 기호를 순서대로 저장하는지 테스트")
  void operatorTest2(String given) {
    assertThat(Operator.isOperator(given)).isTrue();
  }
}