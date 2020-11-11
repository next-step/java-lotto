package step1.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DefaultOperationTest {

  @ParameterizedTest
  @MethodSource("provideSumSource")
  void 문자열_합_검증_테스트(String input, int expect) {
    assertThat(new DefaultOperation(input).sum()).isEqualTo(expect);
  }

  private static Stream<Arguments> provideSumSource() {
    return Stream.of(
        Arguments.of("1:2", 3),
        Arguments.of("2,3,4", 9)
    );
  }
}