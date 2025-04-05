package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PrizeRankTest {

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
  void 일치하는_개수와_보너스_볼에_따라_올바른_등수를_반환한다(int matchCount, boolean hasBonusBall, PrizeRank expectedRank) {
    assertThat(PrizeRank.valueOf(matchCount, hasBonusBall)).isEqualTo(expectedRank);
  }

  @ParameterizedTest
  @CsvSource({
      "FIRST, 2000000000",
      "SECOND, 30000000",
      "THIRD, 1500000",
      "FOURTH, 50000",
      "FIFTH, 5000",
      "MISS, 0"
  })
  void 각_등수는_올바른_상금을_가진다(PrizeRank rank, int expectedPrizeMoney) {
    assertThat(rank.getPrizeMoney()).isEqualTo(expectedPrizeMoney);
  }

  @ParameterizedTest
  @CsvSource({
      "FIRST, false",
      "SECOND, true",
      "THIRD, false",
      "FOURTH, false",
      "FIFTH, false",
      "MISS, false"
  })
  void 보너스_볼이_필요한_등수는_2등뿐이다(PrizeRank rank, boolean expectedHasBonusBall) {
    assertThat(rank.hasBonusBall()).isEqualTo(expectedHasBonusBall);
  }

  @Test
  void 같은_개수의_일치를_가진_등수는_보너스_볼_여부로_구분된다() {
    assertThat(PrizeRank.SECOND.getMatchCount()).isEqualTo(PrizeRank.THIRD.getMatchCount());
    assertThat(PrizeRank.SECOND.hasBonusBall()).isNotEqualTo(PrizeRank.THIRD.hasBonusBall());
  }
} 