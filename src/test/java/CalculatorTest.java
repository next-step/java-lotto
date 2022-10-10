import domain.Calculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

  @Test
  @DisplayName("더하기 테스트")
  void plusTest() {
    Calculator calculator = new Calculator();
    int result = calculator.calculate("1 + 1");
    Assertions.assertThat(result).isEqualTo(2);
  }

  @Test
  @DisplayName("빼기 테스트")
  void minusTest() {
    Calculator calculator = new Calculator();
    int result = calculator.calculate("1 - 1");
    Assertions.assertThat(result).isEqualTo(0);
  }

  @Test
  @DisplayName("곱하기 테스트")
  void multiplyTest() {
    Calculator calculator = new Calculator();
    int result = calculator.calculate("2 * 4");
    Assertions.assertThat(result).isEqualTo(8);
  }

  @Test
  @DisplayName("나누기 테스트")
  void divideTest() {
    Calculator calculator = new Calculator();
    int result = calculator.calculate("4 / 2");
    Assertions.assertThat(result).isEqualTo(2);
  }

  @Test
  @DisplayName("사칙연산이 아닌 연산자 입력시 오류")
  void NonArithmeticQuestion() {
    Calculator calculator = new Calculator();
    Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(
            () -> {
              calculator.calculate("4 ^ 4");
            }
        );
  }

  @Test
  @DisplayName("사칙연산 모두 포함")
  public void calculateTest() {
    Calculator calculator = new Calculator();
    int result = calculator.calculate("2 + 3 * 4 / 2");
    Assertions.assertThat(result).isEqualTo(10);
  }
}
