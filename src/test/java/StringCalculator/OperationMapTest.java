package StringCalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class OperationMapTest {

  @ParameterizedTest(name = "{1} {0} {2} = {3}")
  @MethodSource("operatorTestArguments")
  void operatorBy_수행_성공(String operator, int a, int b, int expected) {
    assertThat(OperationMap.operatorBy(operator, a, b)).isEqualTo(expected);
  }

  private static Stream<Arguments> operatorTestArguments() {
    return Stream.of(
        Arguments.of("+", 1, 2, 3),
        Arguments.of("-", 1, 2, -1),
        Arguments.of("*", 1, 2, 2),
        Arguments.of("/", 1, 2, 0)
    );
  }

  @Test
  void operatorBy_나누기_수행_실패() {
    assertThrows(
        IllegalArgumentException.class,
        () -> OperationMap.operatorBy("/", 1, 0)
    );
  }
}
