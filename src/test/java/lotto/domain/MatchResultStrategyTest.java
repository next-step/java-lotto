package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MatchResultStrategyTest {

  @ParameterizedTest
  @CsvSource({
      "6, false, true",
      "6, true, true",
      "5, true, false",
      "5, false, false",
      "4, true, false",
      "3, false, false",
      "2, true, false",
      "1, false, false",
      "0, false, false"
  })
  void 매칭_조건에_따라_올바른_결과를_반환한다(int matchCount, boolean hasBonusBall, boolean expected) {
    MatchStrategy strategy = new MatchResultStrategy(6, false);
    assertThat(strategy.matches(matchCount, hasBonusBall)).isEqualTo(expected);
  }

  @Test
  void 보너스_볼이_필요한_매칭_전략은_보너스_볼_여부를_체크한다() {
    MatchStrategy strategy = new MatchResultStrategy(5, true);
    assertThat(strategy.matches(5, true)).isTrue();
    assertThat(strategy.matches(5, false)).isFalse();
  }
} 