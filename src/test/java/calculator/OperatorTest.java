package calculator;

import caculator.domain.Number;
import caculator.domain.Operator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class OperatorTest {
  @ParameterizedTest
  @MethodSource("generateTestParameters")
  void Operator_별_연산_성공(int op1, Operator operator, int op2, int expected) {
    Assertions.assertThat(operator.operate(new Number(op1), new Number(op2))).isEqualTo(new Number(expected));
  }

  private static Stream<Arguments> generateTestParameters() {
    return Stream.of(
            arguments(1, Operator.PLUS, 2, 3),
            arguments(20, Operator.MINUS, 5, 15),
            arguments(10, Operator.MULTIPLY, 3, 30),
            arguments(100, Operator.DIVIDE, 2, 50)
    );
  }
}
