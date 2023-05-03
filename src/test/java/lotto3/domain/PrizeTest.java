package lotto3.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PrizeTest {

  @Test
  void 당첨번호와_보너스번호에_따른_적절한_객체_반환_검증() {
    assertThat(Prize.valueOfMatchCountAndBonusNumber(5, true)).isEqualTo(Prize.SECOND);
    assertThat(Prize.valueOfMatchCountAndBonusNumber(5, false)).isEqualTo(Prize.THIRD);
  }
}