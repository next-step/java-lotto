package step1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.of;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class StringCalculatorTest {

  @MethodSource("provideCalculateTestData")
  @ParameterizedTest(name = "문자열 {0}을 전달하는 경우 각 숫자의 합 {1}을 반환한다")
  void calculate(String text, int expected) {
    StringCalculator calculator = new StringCalculator();

    final int actual = calculator.calculate(text);
    assertThat(actual).isEqualTo(expected);
  }

  private static Stream<Arguments> provideCalculateTestData() {
    return Stream.of(
        of(null, 0),
        of("", 0),
        of("1,2", 3),
        of("1,2:3", 6),
        of("//;\n1;2;3", 6)
    );
  }

}
