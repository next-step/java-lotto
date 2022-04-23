package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
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
}
