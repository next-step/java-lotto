package stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static stringcalculator.Expression.ZERO_STRING;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ExpressionTest {

  static Stream<Arguments> parameters() {
    return Stream.of(
        arguments(null, ZERO_STRING),
        arguments("", ZERO_STRING),
        arguments("3,4", "3,4")
    );
  }

  @ParameterizedTest
  @DisplayName("생성 테스트")
  @MethodSource("parameters")
  void create(String parameter, String expected) {
    assertThat(new Expression(parameter)).isEqualTo(new Expression(expected));
  }
}
