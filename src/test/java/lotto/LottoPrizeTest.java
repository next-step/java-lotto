package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoPrizeTest {

  @ParameterizedTest(name = "matchedCount:{1}, hasPrize:{2}로 {0}생성")
  @MethodSource("parametersAndLottoPrize")
  void valueOf_성공(LottoPrize expected, int matchedCount, boolean hasPrize) {
    assertThat(LottoPrize.valueOf(matchedCount, hasPrize)).isEqualTo(expected);
  }

  private static Stream<Arguments> parametersAndLottoPrize() {
    return Stream.of(
        Arguments.of(LottoPrize.NONE, 0, false),
        Arguments.of(LottoPrize.NONE, 1, false),
        Arguments.of(LottoPrize.NONE, 2, false),
        Arguments.of(LottoPrize.THREE, 3, false),
        Arguments.of(LottoPrize.FOUR, 4, false),
        Arguments.of(LottoPrize.FIVE, 5, false),
        Arguments.of(LottoPrize.FIVE_AND_BONUS, 5, true),
        Arguments.of(LottoPrize.SIX, 6, false)
    );
  }
}
