package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PrizeTest {

  @Test
  public void 맞춘_개수에_맞게_올바른_Prize를_반환하는지_확인() {
    assertPrizeForMatches(3, Prize.MATCH_3_TIME);
    assertPrizeForMatches(4, Prize.MATCH_4_TIME);
    assertPrizeForMatches(5, Prize.MATCH_5_TIME);
    assertPrizeForMatches(6, Prize.MATCH_6_TIME);
    assertPrizeForMatches(0, Prize.MATCH_NOT_THING);
    assertPrizeForMatches(1, Prize.MATCH_NOT_THING);
  }

  private void assertPrizeForMatches(int matchedCount, Prize expectedPrize) {
    Prize prize = Prize.getPrizeForMatches(matchedCount);
    assertThat(prize).isEqualTo(expectedPrize);
  }

}