package stringCalculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OperatorTest {

  @Test
  @DisplayName("덧셈 연산 수행에 성공한다")
  void plusTest() {
    Operator operator = new Operator("+");
    assertThat(
        operator.calculate(new Number(1), new Number(2))
    ).isEqualTo(new Number(3));
  }

  @Test
  @DisplayName("곱셈 연산 수행에 성공한다")
  void multiplicationTest() {
    Operator operator = new Operator("*");
    assertThat(
        operator.calculate(new Number(2), new Number(3))
    ).isEqualTo(new Number(6));
  }

  @Test
  @DisplayName("나눗셈 연산 수행에 성공한다")
  void divisionTest() {
    Operator operator = new Operator("/");
    assertThat(
        operator.calculate(new Number(6), new Number(3))
    ).isEqualTo(new Number(2));
  }

  @Test
  @DisplayName("지정된 연산자 외 다른 토큰이 들어가면 예외가 발생한다")
  void notOperatorTest() {
    assertThatThrownBy(() -> new Operator("!"));
  }
}
