package step1.domain.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step1.domain.Number;

class NumbersTest {

  @ParameterizedTest
  @MethodSource("provideConstructSource")
  void 객체_생성_테스트(String input, Pattern pattern, List<Number> expect) {
    assertThat(new Numbers(input, pattern)).isEqualTo(new Numbers(expect));
  }

  @ParameterizedTest
  @MethodSource("provideSumSource")
  void 문자열_합_검증_테스트(String input, Pattern delimiter, Number expect) {
    assertThat(new Numbers(input, delimiter).sum()).isEqualTo(expect);
  }

  private static Stream<Arguments> provideConstructSource() {
    List<Number> numbers = Arrays.asList(new Number(1), new Number(2));
    List<Number> numbers2 = Arrays.asList(new Number(2), new Number(3), new Number(4));

    return Stream.of(
        Arguments.of("1:2", Pattern.compile(":"), numbers),
        Arguments.of("2;3;4", Pattern.compile(";"), numbers2)
    );
  }

  private static Stream<Arguments> provideSumSource() {
    return Stream.of(
        Arguments.of("1:2", Pattern.compile(":"), new Number(3)),
        Arguments.of("2;3;4", Pattern.compile(";"), new Number(9))
    );
  }
}