package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PrizeTierMapperTest {

  @ParameterizedTest
  @CsvSource({
      "0, MATCH_ZERO",
      "1, MATCH_ZERO",
      "2, MATCH_ZERO",
      "3, MATCH_THREE",
      "4, MATCH_FOUR",
      "5, MATCH_FIVE",
      "6, MATCH_SIX",
  })
  void getPrizeTierByMatchCnt(int matchCnt, PrizeTier expected) {
    assertThat(PrizeTierMapper.INSTANCE.getPrizeTierByMatchCnt(matchCnt)).isEqualTo(expected);
  }
}