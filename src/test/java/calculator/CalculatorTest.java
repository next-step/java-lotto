package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CalculatorTest {

  @DisplayName("덧셈 테스트")
  @Test
  void testAdd() {
    String input = "1 + 10";

    int result = Calculator.calculate(input);

    assertThat(result).isEqualTo(11);
  }

  @DisplayName("뺄셈 테스트")
  @Test
  void testMinus() {
    String input = "10 - 10";

    int result = Calculator.calculate(input);

    assertThat(result).isEqualTo(0);
  }

  @DisplayName("곱셈 테스트")
  @Test
  void testMultiply() {
    String input = "10 * 3";

    int result = Calculator.calculate(input);

    assertThat(result).isEqualTo(30);
  }

  @DisplayName("나눗셈 테스트")
  @Test
  void testDivide() {
    String input = "10 / 2";

    int result = Calculator.calculate(input);

    assertThat(result).isEqualTo(5);
  }

  @DisplayName("여러 연산자 테스트")
  @Test
  void testMultipleOperators() {
    String input = "10 + 2 * 3 / 9 - 1";

    int result = Calculator.calculate(input);

    assertThat(result).isEqualTo(3);
  }

  @DisplayName("잘못된 연산자 테스트")
  @Test
  void testInvalidOperator() {
    String input = "10 + 2 * 3 % 9 - 1";

    assertThatThrownBy(() -> Calculator.calculate(input))
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessage("잘못된 연산자입니다.");
  }
}
