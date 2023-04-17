package calculator;

import calculator.domain.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperatorTest {

  @ParameterizedTest(name = "올바른 사칙연산 입력된 경우 계산")
  @CsvSource(value = {"1:+:1:2", "5:*:3:15"}, delimiter = ':')
  public void toCalculation_사칙연산(int input1, String operator, int input2, int expected) {
    assertThat(Operator.toCalculation(operator).apply(input1, input2)).isEqualTo(expected);
  }

  @Test
  @DisplayName("분모에 0 입력하는 경우 IllegalArgumentException throw")
  public void toCalculation_분모_0() {
    assertThatThrownBy(() -> Operator.toCalculation("/").apply(1, 0))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("0으로 나눌 수 없습니다. 다른 숫자를 입력해주세요.");
  }

  @Test
  @DisplayName("연산자가 아닌 기호를 입력하는 경우 IllegalArgumentException throw")
  public void toCalculation_연산자가_아닌_기호() {
    assertThatThrownBy(() -> Operator.toCalculation(":"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("연산자 기호를 입력해주세요.");
  }
}
