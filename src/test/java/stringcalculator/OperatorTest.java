package stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import stringcalculator.exception.IllegalOperatorException;

class OperatorTest {

  @ParameterizedTest
  @DisplayName("정확한 연산자를 기입한 경우, 반환값 확인")
  @CsvSource({"+,SUM", "-,MINUS", "*,MULTIPLY", "/,DIVIDE"})
  void matchExactlyOperator(String input, Operator expected) {
    // when
    Operator result = Operator.findOperator(input);

    // then
    assertThat(result).isEqualTo(expected);
  }

  @Test
  @DisplayName("잘못된 연산자를 기입한 경우, 예외처리")
  void inputIncorrectOperatorException() {
    // given
    String operator = "&";

    // when & then
    assertThatThrownBy(() -> Operator.findOperator(operator))
        .isInstanceOf(IllegalOperatorException.class);
  }

  @ParameterizedTest
  @DisplayName("하나의 연산자에 대한 연산 결과 확인")
  @CsvSource({"2,SUM", "0,MINUS", "1,MULTIPLY", "1,DIVIDE"})
  void checkOperationResultForAnOperator(int expected, Operator operator) {
    // given
    int operand1 = 1;
    int operand2 = 1;

    // when
    int result = operator.calc(operand1, operand2);

    // then
    assertThat(result).isEqualTo(expected);
  }
}
