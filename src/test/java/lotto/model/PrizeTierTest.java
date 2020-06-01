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
}