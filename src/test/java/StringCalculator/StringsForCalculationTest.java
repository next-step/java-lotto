package StringCalculator;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class StringsForCalculationTest {


  @Test
  void StringsForCalculation_생성_성공() {
    assertDoesNotThrow(() -> new StringsForCalculation(List.of("2", "+", "3", "/", "2")));
  }

  private static Stream<Arguments> invalidStringList() {
    return Stream.of(
        Arguments.of(emptyList()),
        Arguments.of(List.of("2", "+")),
        Arguments.of(List.of("2", "+", "2", "+"))
        );
  }

  @ParameterizedTest
  @MethodSource("invalidStringList")
  void StringsForCalculation_생성_실패(List<String> invalidStringList) {
    assertThrows(
        IllegalArgumentException.class,
        () -> new StringsForCalculation(invalidStringList)
    );
  }

  private static Stream<Arguments> calculateSources() {
    return Stream.of(
        Arguments.of(List.of("2", "+", "3", "*", "4", "/", "2"), 10),
        Arguments.of(List.of("1", "+", "1"), 2),
        Arguments.of(List.of("1", "-", "1"), 0),
        Arguments.of(List.of("1", "*", "1", "*", "2"), 2)
        );
  }

  @ParameterizedTest(name = "{0} = {1}")
  @MethodSource("calculateSources")
  void calculate_성공(List<String> stringList, int expected) {
    assertThat(new StringsForCalculation(stringList).calculate()).isEqualTo(expected);
  }

  private static Stream<Arguments> calculateSourcesToFail() {
    return Stream.of(
        Arguments.of(List.of("2", "+", "안", "*", "4", "/", "2")),
        Arguments.of(List.of("1", "+", "+")),
        Arguments.of(List.of("-", "-", "1")),
        Arguments.of(List.of("1", "2", "1", "1", "2")),
        Arguments.of(List.of("", "-", "1", "/", "2")),
        Arguments.of(List.of(" ", "+", "1"))
        );
  }

  @ParameterizedTest
  @MethodSource("calculateSourcesToFail")
  void calculate_실패(List<String> stringListToFail) {
    assertThrows(
        IllegalArgumentException.class,
        () -> new StringsForCalculation(stringListToFail).calculate()
    );
  }
}
