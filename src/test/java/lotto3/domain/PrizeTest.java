package lotto3.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PrizeTest {

  @Test
  void 당첨번호에_따른_적절한_객체_반환_검증() {
    assertThat(Prize.valueOfMatchCount(0)).isEqualTo(Prize.NONE);
    assertThat(Prize.valueOfMatchCount(3)).isEqualTo(Prize.FIFTH);
    assertThat(Prize.valueOfMatchCount(4)).isEqualTo(Prize.FOURTH);
    assertThat(Prize.valueOfMatchCount(5)).isEqualTo(Prize.THIRD);
    assertThat(Prize.valueOfMatchCount(6)).isEqualTo(Prize.FIRST);
  }

  @Test
  void 당첨번호와_보너스번호에_따른_적절한_객체_반환_검증() {
    assertThat(Prize.valueOfMatchCountAndBonusNumber(5, true)).isEqualTo(Prize.SECOND);
    assertThat(Prize.valueOfMatchCountAndBonusNumber(5, false)).isEqualTo(Prize.THIRD);
  }
}