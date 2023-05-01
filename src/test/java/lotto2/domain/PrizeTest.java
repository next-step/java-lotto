package lotto2.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PrizeTest {

  @Test
  public void 맞춘_개수에_맞게_올바른_Prize를_반환하는지_확인() {
    assertPrizeForMatches(3, Prize.FOURTH);
    assertPrizeForMatches(4, Prize.THIRD);
    assertPrizeForMatches(5, Prize.SECOND);
    assertPrizeForMatches(6, Prize.FIRST);
    assertPrizeForMatches(0, Prize.NONE);
    assertPrizeForMatches(1, Prize.NONE);
  }

  private void assertPrizeForMatches(int matchedCount, Prize expectedPrize) {
    Prize prize = Prize.valueOf(matchedCount);
    assertThat(prize).isEqualTo(expectedPrize);
  }

}