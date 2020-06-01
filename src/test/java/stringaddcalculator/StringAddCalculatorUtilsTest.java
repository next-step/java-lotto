package stringaddcalculator;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class StringAddCalculatorUtilsTest {

  @ParameterizedTest
  @CsvSource({
      "'', true",
      "' ', true",
      "a, false",
      "1, false"
  })
  void isNotNullOrEmpty(String param, boolean expected) {
    assertThat(StringAddCalculatorUtils.isNullOrEmpty(param)).isEqualTo(expected);
  }

  @Test
  void isNotNullOrEmpty_Null() {
    assertThat(StringAddCalculatorUtils.isNullOrEmpty(null)).isEqualTo(true);
  }

  @ParameterizedTest
  @MethodSource("numberStrWithNumberArrProvider")
  void splitNumbers(String s, String[] expected) {
    assertThat(StringAddCalculatorUtils.splitNumbers(s)).isEqualTo(expected);
  }

  static Stream<Arguments> numberStrWithNumberArrProvider() {
    return Stream.of(
        Arguments.arguments("1,2", new String[]{"1", "2"}),
        Arguments.arguments("1,2,3", new String[]{"1", "2", "3"})
    );
  }

  @Test
  void findCustomDelimiter() {
    assertThat(StringAddCalculatorUtils.findCustomDelimiter("//;\n1;2;3")).isEqualTo(";");
  }
}