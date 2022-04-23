package stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import stringcalculator.commons.Constant;
import stringcalculator.exception.InputValueException;

public class StringCalculatorTest {

  private StringCalculator stringCalculator;

  @BeforeEach
  void beforeEach() {
    stringCalculator = new StringCalculator();
  }

  @ParameterizedTest
  @NullAndEmptySource
  void inputNullOrEmptyException(String expression) {
    // given

    // when

    // then
    assertThatThrownBy(() -> stringCalculator.calculate(expression))
        .isInstanceOf(InputValueException.class)
        .hasMessage(Constant.INPUT_NULL_ERR_MSG);
  }

  @ParameterizedTest
  @DisplayName("덧셈 연산 결과")
  @CsvSource({"1 + 1,2", "1 + 1 + 1,3", "2 + 1,3"})
  void resultAdditionOperation(String expression, int expected) {
    // given

    // when
    int result = stringCalculator.calculate(expression);

    // then
    assertThat(result).isEqualTo(expected);
  }

  @ParameterizedTest
  @DisplayName("뺄셈 연산 결과")
  @CsvSource({"1 - 1,0", "1 - 1 - 1,-1", "12 - 5,7"})
  void resultMinusOperation(String expression, int expected) {
    // given

    // when
    int result = stringCalculator.calculate(expression);

    // then
    assertThat(result).isEqualTo(expected);
  }

  @ParameterizedTest
  @DisplayName("곱셈 연산 결과")
  @CsvSource({"1 * 1,1", "1 * 3 * 5,15", "4 * -1,-4"})
  void resultMultiplyOperation(String expression, int expected) {
    // given

    // when
    int result = stringCalculator.calculate(expression);

    // then
    assertThat(result).isEqualTo(expected);
  }

  @ParameterizedTest
  @DisplayName("나눗셈 연산 결과")
  @CsvSource({"1 / 1,1", "4 / 2 / 2,1", "12 / 3,4", "4 / -1,-4"})
  void resultDivideOperation(String expression, int expected) {
    // given

    // when
    int result = stringCalculator.calculate(expression);

    // then
    assertThat(result).isEqualTo(expected);
  }

  @ParameterizedTest
  @DisplayName("여러개의 연산자를 통한 계산 결과")
  @CsvSource({"1 + 2 / 3, 1", "2 + 3 * 4 / 2 - 3,7"})
  void resultCalculationMultipleOperators(String expression, int expected) {
    // given

    // when
    int result = stringCalculator.calculate(expression);

    // then
    assertThat(result).isEqualTo(expected);
  }

  @Test
  @DisplayName("잘못된 연산자 입력한 경우 예외처리")
  void inputInvalidOperatorException() {
    // given
    String expression = "1 & 4";

    // when

    // then
    assertThatThrownBy(() -> stringCalculator.calculate(expression))
        .isInstanceOf(InputValueException.class)
        .hasMessage(Constant.INVALID_OPERATOR_INPUT_ERR_MSG);
  }

  @Test
  @DisplayName("0으로 나누기 연산을 한 경우 예외처리")
  void divideByZeroException() {
    // given
    String expression = "1 / 0";

    // when

    // then
    assertThatThrownBy(() -> stringCalculator.calculate(expression))
        .isInstanceOf(InputValueException.class)
        .hasMessage(Constant.DIVIDE_BY_ZERO_ERR_MSG);
  }

  @Test
  @DisplayName("피연산자가 숫자가 아닌 경우 예외처리")
  void operandNotNumberException() {
    // given
    String expression = "& - 3";

    // when

    // then
    assertThatThrownBy(() -> stringCalculator.calculate(expression))
        .isInstanceOf(InputValueException.class)
        .hasMessage(Constant.INPUT_NOT_NUMBER_ERR_MSG);
  }
}
