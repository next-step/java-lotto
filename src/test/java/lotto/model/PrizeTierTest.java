package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PrizeTierTest {

  @ParameterizedTest
  @CsvSource({
      "MATCH_SIX, 2000000000",
      "MATCH_FIVE, 1500000",
      "MATCH_FOUR, 50000",
      "MATCH_THREE, 5000",
      "MATCH_ZERO, 0"
  })
  void getPrize(PrizeTier tier, int prize) {
    assertThat(tier.getPrize()).isEqualTo(prize);
  }

  @ParameterizedTest
  @CsvSource({
      "0, false, MATCH_ZERO",
      "1, false, MATCH_ONE",
      "2, false, MATCH_TWO",
      "3, false, MATCH_THREE",
      "4, false, MATCH_FOUR",
      "5, false, MATCH_FIVE",
      "5, true, MATCH_FIVE_WITH_BONUS",
      "6, false, MATCH_SIX",
  })
  void getPrizeTierByMatchCnt(int matchCnt, boolean matchBonus, PrizeTier expected) {
    assertThat(PrizeTier.valueOf(new MatchCnt(matchCnt, matchBonus))).isEqualTo(expected);
  }
}