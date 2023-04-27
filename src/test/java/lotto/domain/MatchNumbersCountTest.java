package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static lotto.domain.MatchNumbersCount.*;
import static org.assertj.core.api.Assertions.assertThat;

class MatchNumbersCountTest {
  @ParameterizedTest
  @MethodSource("provideMatchCountArguments")
  void 일치하는_숫자를_반환한다(MatchNumbersCount matchNumbersCount, int expectedValue) {
    assertThat(matchNumbersCount.getMatchNumbersCount())
        .isEqualTo(expectedValue);
  }

  private static Stream<Arguments> provideMatchCountArguments() {
    return Stream.of(
        Arguments.of(
            MATCH_0, 0,
            MATCH_1, 1,
            MATCH_2, 2,
            MATCH_3, 3,
            MATCH_4, 4,
            MATCH_5, 5,
            MATCH_6, 6
        )
    );
  }

  @ParameterizedTest
  @MethodSource("providePrizeArguments")
  void 상금을_반환한다(MatchNumbersCount matchNumbersCount, int expectedPrize) {
    assertThat(matchNumbersCount.getPrize())
        .isEqualTo(expectedPrize);
  }

  private static Stream<Arguments> providePrizeArguments() {
    return Stream.of(
        Arguments.of(
            MATCH_0, 0,
            MATCH_1, 0,
            MATCH_2, 0,
            MATCH_3, 5_000,
            MATCH_4, 50_000,
            MATCH_5, 1_500_000,
            MATCH_6, 2_000_000_000
        )
    );
  }
}