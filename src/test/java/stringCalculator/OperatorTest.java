package stringCalculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OperatorTest {

  @Test
  @DisplayName("덧셈 연산 수행에 성공한다")
  void plusTest() {
    Operator operator = Operator.from("+");
    assertThat(
        operator.calculate(new Number(1), new Number(2))
    ).isEqualTo(new Number(3));
  }

  @Test
  @DisplayName("곱셈 연산 수행에 성공한다")
  void multiplicationTest() {
    Operator operator = Operator.from("*");
    assertThat(
        operator.calculate(new Number(2), new Number(3))
    ).isEqualTo(new Number(6));
  }

  @Test
  @DisplayName("나눗셈 연산 수행에 성공한다")
  void divisionTest() {
    Operator operator = Operator.from("/");
    assertThat(
        operator.calculate(new Number(6), new Number(3))
    ).isEqualTo(new Number(2));
  }

  @Test
  @DisplayName("지정된 연산자 외 다른 토큰이 들어가면 예외가 발생한다")
  void notOperatorTest() {
    assertThatThrownBy(() -> Operator.from("!"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("지원하지 않는 연산자입니다.");
  }
}
