package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import calculator.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringCalculatorTest {

  @Test
  void 사칙연산의계산우선순위가아닌입력값에따라계산순서가결정된다() {
    String input = "2 + 3 * 4 / 2";
    int result = new Calculator().calculation(input);
    assertThat(result).isEqualTo(10);
  }

  @Test
  void 사칙연산기호가아닌경우IllegalArgumentException() {
    String input = "1 ^ 1";
    assertThatIllegalArgumentException().isThrownBy(() -> {
      new Calculator().calculation(input);
    });
  }

  @Test
  void 숫자와사칙연산사이에는반드시빈공백문자열이있어야한다() {
    String input = "1 + 2 * 3- 1";
    assertThatExceptionOfType(NumberFormatException.class).isThrownBy(() -> {
      new Calculator().calculation(input);
    });
  }

  @ParameterizedTest
  @ValueSource(strings = {"+ 1 +", "1 + +"})
  void 첫문자와끝문자는숫자여야한다_사칙연산이아니어야한다(String input) {
    assertThatExceptionOfType(NumberFormatException.class).isThrownBy(() -> {
      new Calculator().calculation(input);
    });
  }

  @ParameterizedTest
  @ValueSource(strings = {"", "  ", })
  void 입력값이빈공백일경우IllegalArgumentException(String input) {
    assertThatIllegalArgumentException().isThrownBy(() -> {
      new Calculator().validInput(input);
    });
  }

  @Test
  void 입력값이null일경우IllegalArgumentException() {
    assertThatIllegalArgumentException().isThrownBy(() -> {
      new Calculator().validInput(null);
    });
  }

}
