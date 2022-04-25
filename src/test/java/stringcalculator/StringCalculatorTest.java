package stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import stringcalculator.exception.IllegalNumberException;
import stringcalculator.exception.IllegalOperatorException;

public class StringCalculatorTest {

  private static final StringCalculator stringCalculator = new StringCalculator();

  @ParameterizedTest
  @DisplayName("null 및 empty가 입력으로 들어온 경우 예외처리")
  @NullAndEmptySource
  void inputNullOrEmptyException(String expression) {
    // when & then
    assertThatThrownBy(() -> stringCalculator.calculate(expression))
        .isInstanceOf(NullPointerException.class);
  }

  @ParameterizedTest
  @DisplayName("덧셈 연산 결과")
  @CsvSource({"1 + 1,2", "1 + 1 + 1,3", "2 + 1,3"})
  void resultAdditionOperation(String expression, int expected) {
    // when
    int result = stringCalculator.calculate(expression).getValue();

    // then
    assertThat(result).isEqualTo(expected);
  }

  @ParameterizedTest
  @DisplayName("뺄셈 연산 결과")
  @CsvSource({"1 - 1,0", "1 - 1 - 1,-1", "12 - 5,7"})
  void resultMinusOperation(String expression, int expected) {
    // when
    int result = stringCalculator.calculate(expression).getValue();

    // then
    assertThat(result).isEqualTo(expected);
  }

  @ParameterizedTest
  @DisplayName("곱셈 연산 결과")
  @CsvSource({"1 * 1,1", "1 * 3 * 5,15", "4 * -1,-4"})
  void resultMultiplyOperation(String expression, int expected) {
    // when
    int result = stringCalculator.calculate(expression).getValue();

    // then
    assertThat(result).isEqualTo(expected);
  }

  @ParameterizedTest
  @DisplayName("나눗셈 연산 결과")
  @CsvSource({"1 / 1,1", "4 / 2 / 2,1", "12 / 3,4", "4 / -1,-4"})
  void resultDivideOperation(String expression, int expected) {
    // when
    int result = stringCalculator.calculate(expression).getValue();

    // then
    assertThat(result).isEqualTo(expected);
  }

  @ParameterizedTest
  @DisplayName("여러개의 연산자를 통한 계산 결과")
  @CsvSource({"1 + 2 / 3, 1", "2 + 3 * 4 / 2 - 3,7"})
  void resultCalculationMultipleOperators(String expression, int expected) {
    // when
    int result = stringCalculator.calculate(expression).getValue();

    // then
    assertThat(result).isEqualTo(expected);
  }

  @Test
  @DisplayName("잘못된 연산자 입력한 경우 예외처리")
  void inputInvalidOperatorException() {
    // given
    String expression = "1 & 4";

    // when & then
    assertThatThrownBy(() -> stringCalculator.calculate(expression))
        .isInstanceOf(IllegalOperatorException.class);
  }

  @Test
  @DisplayName("0으로 나누기 연산을 한 경우 예외처리")
  void divideByZeroException() {
    // given
    String expression = "1 / 0";

    // when & then
    assertThatThrownBy(() -> stringCalculator.calculate(expression))
        .isInstanceOf(ArithmeticException.class);
  }

  @Test
  @DisplayName("피연산자가 숫자가 아닌 경우 예외처리")
  void operandNotNumberException() {
    // given
    String expression = "& - 3";

    // when & then
    assertThatThrownBy(() -> stringCalculator.calculate(expression))
        .isInstanceOf(IllegalNumberException.class);
  }
}
