package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static lotto.domain.PrizeGrade.*;
import static org.assertj.core.api.Assertions.assertThat;

class PrizeGradeTest {

  @ParameterizedTest
  @MethodSource("providePrizeGradeMaterial")
  void 객체생성_테스트(int matchCount, boolean isBonusMatch, PrizeGrade result) {
    assertThat(PrizeGrade.of(matchCount, isBonusMatch)).isEqualTo(result);
  }

  static Stream<Arguments> providePrizeGradeMaterial() {
    return Stream.of(
        Arguments.of(3, false, FIFTH_CLASS),
        Arguments.of(4, false, FOURTH_CLASS),
        Arguments.of(5, false, THIRD_CLASS),
        Arguments.of(5, true, SECOND_CLASS),
        Arguments.of(6, false, FIRST_CLASS)
    );
  }
}