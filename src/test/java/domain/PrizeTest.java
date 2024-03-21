package domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

public class PrizeTest {
  @ParameterizedTest
  @MethodSource("generateTestParameters")
  void Prize_생성자_테스트(Result result, Prize expected) {
    assertThat(Prize.from(result)).isEqualTo(expected);
  }

  private static Stream<Arguments> generateTestParameters() {
    return Stream.of(
            arguments(Result.of(0, false), Prize.NONE),
            arguments(Result.of(1, true), Prize.NONE),
            arguments(Result.of(2, false), Prize.NONE),
            arguments(Result.of(3, true), Prize.FIFTH),
            arguments(Result.of(4, false), Prize.FORTH),
            arguments(Result.of(5, false), Prize.THIRD),
            arguments(Result.of(5, true), Prize.SECOND),
            arguments(Result.of(6, false), Prize.FIRST)
    );
  }
}
