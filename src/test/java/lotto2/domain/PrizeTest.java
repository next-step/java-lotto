package lotto2.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PrizeTest {

  @Test
  void 당첨개수에_따른_적절한_Prize_반환_검증() {
    int matchingCount = 3;
    Prize prize = Prize.valueOfMatchCount(matchingCount);

    assertThat(prize).isEqualTo(Prize.FOURTH);
  }
}