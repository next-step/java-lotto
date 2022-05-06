package calculator.v2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("계산기 테스트")
public class CalculatorTest {

  @DisplayName("트리로 계산 수행 후 결과를 출력한다")
  @ParameterizedTest
  @CsvSource(value = {"1=1", "1 / 1=1", "1 - 2 =-1", "2 + 3 * 4 / 2=10",
      "1 / 2 * 4 + 2 - 1=1"}, delimiter = '=')
  void calculate(String input, int expect) {
    assertThat(Calculator.calculate(input)).isEqualTo(expect);
  }

  @DisplayName("0으로 나누는 표현식이 포함되면 예외를 던진다")
  @ParameterizedTest
  @ValueSource(strings = {"1 / 0", "1 / 0 * 1", "1 + 1 / 0", "1 - 1 / 0"})
  void divideByZeroException(String input) {
    assertThatExceptionOfType(NumberFormatException.class).isThrownBy(
        () -> Calculator.calculate(input));
  }

  @DisplayName("null 또는 빈 입력값은 예외를 던진다")
  @ParameterizedTest
  @NullAndEmptySource
  void calculate(String input) {
    assertThatIllegalArgumentException().isThrownBy(() -> Calculator.calculate(input));
  }
}
