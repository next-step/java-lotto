package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class OperationTest {

  private static Stream<Arguments> operatorAndOperation() {
    return Stream.of(
        Arguments.of("+", Operation.ADD),
        Arguments.of("-", Operation.SUBTRACT),
        Arguments.of("*", Operation.MULTIPLY),
        Arguments.of("/", Operation.DIVIDE)
    );
  }

  @ParameterizedTest
  @MethodSource("operatorAndOperation")
  void valueOfOperator(String operator, Operation operation) {
    assertThat(Operation.valueOfOperator(operator)).isEqualTo(operation);
  }

  @Test
  void getOperatorSet() {
    assertThat(Operation.getOperatorSet()).contains("+", "-", "/", "*");
  }

  @Test
  void add() {
    assertThat(Operation.ADD.apply(4, 2)).isEqualTo(6);
  }

  @Test
  void subtract() {
    assertThat(Operation.SUBTRACT.apply(4, 2)).isEqualTo(2);
  }

  @Test
  void multiply() {
    assertThat(Operation.MULTIPLY.apply(4, 2)).isEqualTo(8);
  }

  @Test
  void divide() {
    assertThat(Operation.DIVIDE.apply(4, 2)).isEqualTo(2);
  }

  @DisplayName("0으로 나누면 ArithmeticException이 발생한다.")
  @Test
  void divide_zero() {
    assertThatThrownBy(() -> Operation.DIVIDE.apply(4, 0))
        .isInstanceOf(ArithmeticException.class);
  }

  @ParameterizedTest(name = "null은 계산할 수 없다.")
  @MethodSource("operatorAndOperation")
  void operate_null(String operator, Operation operation) {
    assertThatThrownBy(() -> operation.apply(null, null))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
