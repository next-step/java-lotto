package stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static stringcalculator.Expression.WRONG_CUSTOM_DELIMITER_MESSAGE;
import static stringcalculator.Expression.ZERO_STRING;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

  static Stream<Arguments> commaDelimiter() {
    return Stream.of(
        arguments("1,2", new String[]{"1", "2"}),
        arguments("1:2", new String[]{"1", "2"}),
        arguments("1,2:3", new String[]{"1", "2", "3"}),
        arguments("//:\n1:2:3", new String[]{"1", "2", "3"})
    );
  }

  @ParameterizedTest
  @DisplayName("생성 테스트")
  @MethodSource("parameters")
  void create(String parameter, String expected) {
    assertThat(new Expression(parameter)).isEqualTo(new Expression(expected));
  }

  @ParameterizedTest
  @DisplayName("구분자를 받아서 숫자 목록을 반환합니다.")
  @MethodSource("commaDelimiter")
  void commaSeparatedNumbers(String expression, String[] numbers) {
    assertThat(new Expression(expression).numbers()).contains(numbers);
  }

  @Test
  @DisplayName("잘못된 커스텀 구분자 입력시 IllegalArgumentException이 발생한다.")
  void wrongCustomDelimiter() {
    assertThatIllegalArgumentException().isThrownBy(
        () -> new Expression("//\n123")
    ).withMessage(WRONG_CUSTOM_DELIMITER_MESSAGE);
  }
}
