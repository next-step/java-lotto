import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {

  public static final String DELIMITER = " ";
  private Calculator calculator;

  @BeforeEach
  void setUp() {
    calculator = new Calculator();
  }

  @Test
  void 덧셈() {
    String[] tokens = "2 + 3".split(DELIMITER);
    assertThat(calculator.calculate(tokens)).isEqualTo(5);
  }

  @Test
  void 뺄셈() {
    String[] tokens = "5 - 3".split(DELIMITER);
    assertThat(calculator.calculate(tokens)).isEqualTo(2);
  }

  @Test
  void 곱셈() {
    String[] tokens = "4 * 3".split(DELIMITER);
    assertThat(calculator.calculate(tokens)).isEqualTo(12);
  }

  @Test
  void 나눗셈() {
    String[] tokens = "6 / 2".split(DELIMITER);
    assertThat(calculator.calculate(tokens)).isEqualTo(3);
  }

  @Test
  void 복합_연산() {
    String[] tokens = "2 + 3 * 4 - 6 / 2".split(DELIMITER);
    assertThat(calculator.calculate(tokens)).isEqualTo(7);
  }

  @Test
  void 지원하지_않는_연산자_사용_시_예외_발생() {
    String[] tokens = "2 ^ 3".split(DELIMITER);
    assertThatThrownBy(() -> calculator.calculate(tokens))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("지원하지 않는 연산자입니다.");
  }
} 