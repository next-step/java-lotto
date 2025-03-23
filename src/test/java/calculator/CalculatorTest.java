package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
}
