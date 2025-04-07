package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MatchResultTest {

  @ParameterizedTest
  @CsvSource({
      "6, false, FIRST",
      "5, true, SECOND",
      "5, false, THIRD",
      "4, false, FOURTH",
      "3, false, FIFTH",
      "2, false, MISS",
      "1, false, MISS",
      "0, false, MISS"
  })
  void 매칭_결과에_따른_당첨_등수_계산(int matchCount, boolean hasBonusMatch, PrizeRank expectedRank) {
    assertThat(MatchResult.of(matchCount, hasBonusMatch).toPrizeRank()).isEqualTo(expectedRank);
  }
} 