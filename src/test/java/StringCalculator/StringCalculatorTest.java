package StringCalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringCalculatorTest {

  @Test
  void StringCalculator_생성_성공() {
    assertDoesNotThrow(() -> StringCalculator.init("2 + 3 * 4 / 2"));
  }

  @ParameterizedTest
  @ValueSource(strings = {" "})
  void StringCalculator_생성_실패(String invalidInput) {
    assertThrows(IllegalArgumentException.class,
        () -> StringCalculator.init(invalidInput));
  }

  private static Stream<Arguments> runSources() {
    return Stream.of(
        Arguments.of("2 + 3 * 4 / 2", 10),
        Arguments.of("1 + 1", 2),
        Arguments.of("1 - 1", 0),
        Arguments.of("1 * 1 * 2", 2)
    );
  }

  @ParameterizedTest(name = "{0} = {1}")
  @MethodSource("runSources")
  void run_성공(String input, int expected) {
    assertThat(StringCalculator.init(input).run()).isEqualTo(expected);
  }

  private static Stream<Arguments> runSourcesToFail() {
    return Stream.of(
        Arguments.of("2 + 안 * 4 / 2"),
        Arguments.of("1 + +"),
        Arguments.of("- - 1"),
        Arguments.of("1 2 1 1 2"),
        Arguments.of(" - 1 / 2"),
        Arguments.of("  + 1"),
        Arguments.of("1+1")
    );
  }

  @ParameterizedTest(name = "{0}은 run에서 실패함")
  @MethodSource("runSourcesToFail")
  void run_실패(String value) {
    assertThrows(
        IllegalArgumentException.class,
        () -> StringCalculator.init(value).run()
    );
  }
}
