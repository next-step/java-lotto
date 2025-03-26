import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {

  private Calculator calculator;

  @BeforeEach
  void setUp() {
    calculator = new Calculator();
  }

  @Test
  void 덧셈() {
    Formula formula = new Formula("2 + 3");
    assertThat(formula.calculateBy(calculator)).isEqualTo(5);
  }

  @Test
  void 뺄셈() {
    Formula formula = new Formula("5 - 3");
    assertThat(formula.calculateBy(calculator)).isEqualTo(2);
  }

  @Test
  void 곱셈() {
    Formula formula = new Formula("4 * 3");
    assertThat(formula.calculateBy(calculator)).isEqualTo(12);
  }

  @Test
  void 나눗셈() {
    Formula formula = new Formula("6 / 2");
    assertThat(formula.calculateBy(calculator)).isEqualTo(3);
  }

  @Test
  void 복합_연산() {
    Formula formula = new Formula("2 + 3 * 4 - 6 / 2");
    assertThat(formula.calculateBy(calculator)).isEqualTo(11);
  }

  @Test
  void 지원하지_않는_연산자_사용_시_예외_발생() {
    Formula formula = new Formula("2 ^ 3");
    assertThatThrownBy(() -> formula.calculateBy(calculator))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("지원하지 않는 연산자입니다.");
  }
} 